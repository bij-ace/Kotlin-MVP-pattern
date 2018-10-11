package com.zytech.app.root

import com.zytech.app.api.ApiModule
import com.zytech.app.feed.FeedFragment
import com.zytech.app.feed.FeedModule
import com.zytech.app.main.MainActivity
import com.zytech.app.main.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ApiModule::class,
    MainModule::class,
    FeedModule::class
])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(feedFragment: FeedFragment)
}