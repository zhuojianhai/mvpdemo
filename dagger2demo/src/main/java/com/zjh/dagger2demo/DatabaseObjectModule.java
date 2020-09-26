package com.zjh.dagger2demo;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseObjectModule {
    @Provides
    public DatabaseObject provideDatabaseObject(){
        return  new DatabaseObject();
    }
}
