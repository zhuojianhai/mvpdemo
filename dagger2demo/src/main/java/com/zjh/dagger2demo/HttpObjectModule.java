package com.zjh.dagger2demo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class HttpObjectModule {

    @Singleton
    @Provides
    public HttpObject provideHttoObject(){
        return  new HttpObject();
    }
}
