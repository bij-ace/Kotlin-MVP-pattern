package com.zytech.app.feed

import com.zytech.app.api.ZytechApi
import com.zytech.app.model.Feed
import rx.Observable

class FeedModel(var mApiService: ZytechApi): FeedFragmentMVP.Model {

    companion object {
        private var instance: FeedModel? = null

        fun getInstance(mApiService: ZytechApi): FeedModel {
            if (instance == null) {
                instance = FeedModel(mApiService)
            }
            return instance!!
        }
    }

    override fun getFeed(): Observable<List<Feed>> {
        return mApiService.getFeeds()
    }

}