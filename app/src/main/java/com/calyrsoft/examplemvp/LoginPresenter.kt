package com.calyrsoft.examplemvp

import android.content.Context

class LoginPresenter(val view: IContractLogin.View, val context: Context): IContractLogin.Presenter {
    override fun login(userName: String, password: String) {
        if( userName.isEmpty()) {
            view.showErrorUserName( context.getString(R.string.login_form_username_empty))
        } else {
            if( userName == "calyr") {
                view.showMessage(context.getString(R.string.login_form_success))
            } else {
                view.showMessage(context.getString(R.string.login_form_error))
            }

        }
    }
}