package com.zytech.app.main

class MainActivityPresenter(var mainModel: MainActivityMVP.Model): MainActivityMVP.Presenter {

    var mainView: MainActivityMVP.View? = null

    override fun setView(view: MainActivityMVP.View) {
        this.mainView = view
    }

    override fun groupTabClicked() {
        mainView!!.showGroupFragment()
    }

    override fun feedTabClicked() {
        mainView!!.showFeedFragment()
    }

    override fun editTabClicked() {
        mainView!!.showEditFragment()
    }

    override fun inboxTabClicked() {
        mainView!!.showInboxFragment()
    }

    override fun notificationTabClicked() {
        mainView!!.showNotificationFragment()
    }
}