package com.zjh.dagger2demo;

import javax.inject.Inject;

public class DaggerTest {
    @Inject
    HttpObject httpObject;

    @Inject
    HttpObject httpObject1;
    @Inject
    DatabaseObject databaseObject;

    public static void main(String[] args) {
        DaggerTest myClass = new DaggerTest();
        DaggerMyComponent.builder().build().injectDaggerTest(myClass);
        System.out.println("httpObject---"+myClass.httpObject.hashCode());
        System.out.println("httpObject1---"+myClass.httpObject1.hashCode());
        System.out.println("============");
    }

}
