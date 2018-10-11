package com.zytech.app.main

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainActivityPresenter(model: MainActivityMVP.Model): MainActivityMVP.Presenter{
        return MainActivityPresenter(model)
    }

    @Provides
    fun provideMainActivityModel(): MainActivityMVP.Model{
        return MainModel()
    }

}