package com.zytech.app.feed

import com.zytech.app.api.ZytechApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeedModule {

    @Singleton
    @Provides
    fun provideFeedFragmentPresenter(model: FeedFragmentMVP.Model): FeedFragmentMVP.Presenter{
        return FeedFragmentPresenter.getInstance(model)
    }

    @Singleton
    @Provides
    fun provideFeedModel(mApiService: ZytechApi):FeedFragmentMVP.Model{
        return FeedModel.getInstance(mApiService)
    }

}