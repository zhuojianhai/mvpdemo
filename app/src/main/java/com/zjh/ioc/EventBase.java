package com.zjh.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE) //注解上的注解
public @interface EventBase {
    //    textView.setOnClickListener（new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//        }
//    });
    //1.setOnClickListener 订阅关系
    String listenerSetter();

    //2.new View.OnClickListener()  事件本身
    Class<?> listenerType();

    //3.事件处理程序
    String callbackMethod();
}
