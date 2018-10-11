package com.zytech.app.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.zytech.app.R
import com.zytech.app.feed.FeedFragment
import com.zytech.app.root.ZytechApp
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityMVP.View {

    @Inject
    lateinit var presenter: MainActivityMVP.Presenter

    lateinit var feedFragment: FeedFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ZytechApp).getComponent().inject(this@MainActivity)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_group -> consume{
                    presenter.groupTabClicked()
                }
                R.id.nav_feed -> consume{
                    presenter.feedTabClicked()
                }
                R.id.nav_edit -> consume{
                    presenter.editTabClicked()
                }
                R.id.nav_inbox -> consume{
                    presenter.inboxTabClicked()
                }
                R.id.nav_notification -> consume{
                    presenter.notificationTabClicked()
                }
                else -> consume{
                }
            }
        }

    }

    private fun init() {
        feedFragment = FeedFragment()
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this@MainActivity)
    }

    override fun showGroupFragment() {
        Toast.makeText(this@MainActivity, "Group", Toast.LENGTH_SHORT).show()
    }

    override fun showFeedFragment() {
        Toast.makeText(this@MainActivity, "Feed", Toast.LENGTH_SHORT).show()
        setFragment(feedFragment)
    }

    override fun showEditFragment() {
        Toast.makeText(this@MainActivity, "Edit", Toast.LENGTH_SHORT).show()
    }

    override fun showInboxFragment() {
        Toast.makeText(this@MainActivity, "Inbox", Toast.LENGTH_SHORT).show()
    }

    override fun showNotificationFragment() {
        Toast.makeText(this@MainActivity, "Notification", Toast.LENGTH_SHORT).show()
    }

    private fun setFragment(fragment: Fragment) {
        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrame, fragment)
        fragmentTransaction.commit()
    }

    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }

}
