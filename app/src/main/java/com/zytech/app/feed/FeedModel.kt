package com.zytech.app.feed

import com.zytech.app.api.ZytechApi
import com.zytech.app.model.Feed
import rx.Observable

class FeedModel(var mApiService: ZytechApi): FeedFragmentMVP.Model {

    override fun getFeed(): Observable<List<Feed>> {
        return mApiService.getFeeds()
    }

}