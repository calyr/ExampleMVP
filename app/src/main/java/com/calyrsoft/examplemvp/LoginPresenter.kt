package com.calyrsoft.examplemvp

import android.content.Context
import android.content.res.Resources

class LoginPresenter(val view: ILoginView, val context: Context): ILoginPresenter {
    override fun login(userName: String, password: String) {
        if( userName.isEmpty()) {
            view.showErrorUserName( context.getString(R.string.login_form_username_empty))
        } else {
            view.showMessage(context.getString(R.string.login_form_success))
        }
    }
}