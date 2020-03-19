package com.calyrsoft.examplemvp

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {
    companion object {
        private val NAME_PREF = "mobile.mvp.ucb.edu.bo"
        private val IS_LOGIN = "session_login"
        private val USER_DATA = "user_login"
    }

    private val pref : SharedPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE )

    var isLogin: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)
        set(value) = pref.edit().putBoolean(IS_LOGIN, value).apply()

    var dataUser: String?
        get() = pref.getString(USER_DATA, null)
        set(value) = pref.edit().putString(USER_DATA, value).apply()
}