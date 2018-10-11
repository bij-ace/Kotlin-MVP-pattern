package com.zytech.app.root

import android.app.Application
import com.zytech.app.api.ApiModule
import com.zytech.app.feed.FeedModule
import com.zytech.app.main.MainModule

class ZytechApp: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this@ZytechApp))
                .apiModule(ApiModule())
                .mainModule(MainModule())
                .feedModule(FeedModule())
                .build()
    }

    open fun getComponent(): ApplicationComponent{
        return applicationComponent
    }

}