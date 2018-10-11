package com.zytech.app.api

import com.zytech.app.model.Feed
import retrofit2.http.GET
import rx.Observable

interface ZytechApi {

    @GET("5bb5037f3000006300aabc2e")
    fun getFeeds(): Observable<List<Feed>>

}