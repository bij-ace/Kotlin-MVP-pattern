package com.zytech.app.main

interface MainActivityMVP {

    interface Model{

    }

    interface View{
        fun showGroupFragment()
        fun showFeedFragment()
        fun showEditFragment()
        fun showInboxFragment()
        fun showNotificationFragment()
    }

    interface Presenter{
        fun setView(view: View)

        fun groupTabClicked()
        fun feedTabClicked()
        fun editTabClicked()
        fun inboxTabClicked()
        fun notificationTabClicked()
    }

}