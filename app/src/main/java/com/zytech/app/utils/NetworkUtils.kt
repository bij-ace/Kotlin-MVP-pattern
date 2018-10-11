package com.example.bijesh.udemy.utils

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtils {

    fun isNetworkAvailable(act: Context): Boolean {
        val connectivityManager = act.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}