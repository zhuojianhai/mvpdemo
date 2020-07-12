package com.zjh.ioc;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

@EventBase(listenerSetter = "setOnClickListener",
        listenerType = View.OnClickListener.class,
        callbackMethod = "onClick")
public @interface OnClick {
    int[] value() default -1;//绑定事件的view可能是多个

}
