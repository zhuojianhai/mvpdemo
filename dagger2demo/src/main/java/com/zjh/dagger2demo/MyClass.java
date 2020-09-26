package com.zjh.dagger2demo;

import javax.inject.Inject;

public class MyClass {

    @Inject
    DatabaseObject databaseObject;
    @Inject
    HttpObject httpObject;

    @Inject
    HttpObject httpObject1;


    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        DaggerMyComponent.builder().build().injectMyClas(myClass);

        System.out.println("httpObject---"+myClass.httpObject.hashCode());
        System.out.println("httpObject1---"+myClass.httpObject1.hashCode());
        System.out.println("============");

    }
}
