package com.zytech.app.feed

import android.util.Log
import com.google.gson.Gson
import com.zytech.app.model.Feed
import rx.Observer
import rx.schedulers.Schedulers

class FeedFragmentPresenter constructor(private var feedModel: FeedFragmentMVP.Model) : FeedFragmentMVP.Presenter {

    var feedView: FeedFragmentMVP.View? = null

    var feedList: List<Feed> = mutableListOf()

    companion object {
        private var instance: FeedFragmentPresenter? = null

        fun getInstance(feedModel: FeedFragmentMVP.Model): FeedFragmentPresenter {
            if (instance == null) {
                instance = FeedFragmentPresenter(feedModel)
            }
            return instance!!
        }
    }

    override fun setView(view: FeedFragmentMVP.View) {
        this.feedView = view
    }

    override fun loadFeed() {
        if (!feedList.isEmpty()) {
            Log.e("feed", "old feed")
            feedView!!.showFeed(feedList)
        } else {
            feedModel.getFeed().subscribeOn(Schedulers.newThread())
                    .observeOn(Schedulers.io())
                    .subscribe(object : Observer<List<Feed>> {
                        override fun onCompleted() {}

                        override fun onError(e: Throwable) {
                            e.printStackTrace()
                        }

                        override fun onNext(t: List<Feed>) {
                            Log.e("feed", Gson().toJson(t))
                            feedList = t
                            feedView!!.showFeed(feedList)
                        }
                    })
        }
    }

}