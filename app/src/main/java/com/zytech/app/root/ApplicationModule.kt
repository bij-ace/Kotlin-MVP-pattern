package com.zytech.app.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context{
        return application
    }

}