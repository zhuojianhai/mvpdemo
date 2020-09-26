package com.zjh.dagger2demo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpObjectModule.class,DatabaseObjectModule.class})
public interface MyComponent {

    //不能使用多态，
    void injectMyClas(MyClass myClass);
    void injectDaggerTest(DaggerTest myClass);

}
