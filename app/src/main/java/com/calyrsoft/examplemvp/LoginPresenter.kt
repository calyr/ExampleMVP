package com.calyrsoft.examplemvp

import android.content.Context
import android.os.Handler

class LoginPresenter(val view: IContractLogin.View, val context: Context): IContractLogin.Presenter {
    override fun login(userName: String, password: String) {
        view.showLoading()
        val runnable = Runnable {
            view.hideLoading()
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
        Handler().postDelayed(runnable, 6000)
    }
}