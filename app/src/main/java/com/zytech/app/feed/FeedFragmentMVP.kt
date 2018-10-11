package com.zytech.app.feed

import com.zytech.app.model.Feed
import rx.Observable

interface FeedFragmentMVP {

    interface Model{
        fun getFeed(): Observable<List<Feed>>

    }

    interface View{
        fun showFeed(t: List<Feed>?)

    }

    interface Presenter{
        fun setView(view: View)
        fun loadFeed()
    }

}