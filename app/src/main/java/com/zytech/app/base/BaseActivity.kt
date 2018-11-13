package com.zytech.app.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.zytech.app.R

open class BaseActivity: AppCompatActivity() {

    fun setLayout(layout: Int, theme: Int){
        setTheme(theme)
        setContentView(layout)
    }

}