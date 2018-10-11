package com.zytech.app.feed


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bijesh.udemy.utils.NetworkUtils
import com.zytech.app.R
import com.zytech.app.model.Feed
import com.zytech.app.root.ZytechApp
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject


class FeedFragment : Fragment(), FeedFragmentMVP.View {

    @Inject
    lateinit var presenter: FeedFragmentMVP.Presenter

    override fun onAttach(context: Context?) {
        (activity!!.application as ZytechApp).getComponent().inject(this@FeedFragment)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setView(this@FeedFragment)

        rvFeeds.layoutManager = LinearLayoutManager(activity!!.application)

        if (NetworkUtils().isNetworkAvailable(activity!!.application))
            presenter.loadFeed()
    }

    override fun showFeed(feeds: List<Feed>?) {
        rvFeeds.post {
            rvFeeds.adapter = FeedAdapter(activity!!.application, feeds)
        }
    }

}
