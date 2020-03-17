package com.calyrsoft.examplemvp

import android.app.Application
val session: Pref by lazy {
    App.pref!!
}

class App: Application() {
    companion object {
        var pref: Pref? = null
    }

    override fun onCreate() {
        pref = Pref(applicationContext)
        super.onCreate()
    }
}