package com.zjh.ioc;

import android.content.Context;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InjectUtils {

    public static void inject(Context context){
        //布局的注入
        injectLayout(context);
        //控件的注入
        injectView(context);
        //事件的注入 建议使用injectEvent
        injectClick(context);
    }


    /**
     * 给Activity 设置布局
     * @param context
     */
    private static void injectLayout(Context context) {
        int layoutId = 0;
        Annotation[] annotations = context.getClass().getAnnotations();
        for (Annotation annotation:annotations){
            if (annotation instanceof ContentView){
                layoutId = ((ContentView) annotation).value();
                try {
                    /**
                     * 为什么使用 context.getClass().getDeclaredMethod("setContentView",int.class); 会找不到方法？？？
                     */
                    Method setContentViewById = context.getClass().getMethod("setContentView",int.class);
                    setContentViewById.invoke(context,layoutId);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private  static void injectView(Context context){
        Class<?> clazz = context.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            int resId = viewInject.value();

            try {
                Method findViewByIdMethod = clazz.getMethod("findViewById",int.class);
              View view =
                      (View) findViewByIdMethod.invoke(context,resId);

              field.setAccessible(true);
              field.set(context,view);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        }


    }

    private static void injectClick(Context context){
        //需要一次性处理安卓中23种事件
        Class<?> clazz=context.getClass();
        Method[] methods=clazz.getDeclaredMethods();

        for (Method method : methods) {
            //注意，别把代码写死了 method.getAnnotation(OnClick.class);
            Annotation[] annotations=method.getAnnotations();
            for (Annotation annotation : annotations) {
                //annotation是事件比如onClick 就去取对应的注解
                Class<?> annotationClass=annotation.annotationType();
                EventBase eventBase=annotationClass.getAnnotation(EventBase.class);
                //如果没有eventBase，则表示当前方法不是一个事件处理的方法
                if(eventBase==null){
                    continue;
                }
                //否则就是一个事件处理的方法
                //开始获取事件处理的相关信息（三要素）
                //用于确定是哪种事件
//                btn.setOnClickListener（new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
                //1.setOnClickListener 订阅关系
//                String listenerSetter();
                String listenerSetter=eventBase.listenerSetter();
                //2.new View.OnClickListener()  事件本身
//                Class<?> listenerType();
                Class<?> listenerType=eventBase.listenerType();
                //3.事件处理程序
//                String callbackMethod();
                String callBackMethod=eventBase.callbackMethod();

                //得到3要素之后，就可以执行代码了
                Method valueMethod=null;
                try{
                    //反射得到id,再根据ID号得到对应的VIEW（Button）
                    valueMethod=annotationClass.getDeclaredMethod("value");
                    int[] viewId=(int[])valueMethod.invoke(annotation);
                    for (int id : viewId) {
                        //为了得到Button对象,使用findViewById
                        Method findViewById=clazz.getMethod("findViewById",int.class);
                        View view=(View)findViewById.invoke(context,id);
                        //运行到这里，view就相到于我们写的Button
                        if(view==null){
                            continue;
                        }
                        //activity==context    click===method
                        ListenerInvocationHandler listenerInvocationHandler=
                                new ListenerInvocationHandler(context,method);

                        //做代理   new View.OnClickListener()对象
                        Object proxy= Proxy.newProxyInstance(listenerType.getClassLoader()
                                ,new Class[]{listenerType},listenerInvocationHandler);
                        //执行  让proxy执行的onClick()
                        //参数1  setOnClickListener（）
                        //参数2  new View.OnClickListener()对象
                        //   view.setOnClickListener（new View.OnClickListener()）
                        Method onClickMethod=view.getClass().getMethod(listenerSetter,listenerType);
                        onClickMethod.invoke(view,proxy);
                        //这时候，点击按钮时就会去执行代理类中的invoke方法()

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }

    }
}
