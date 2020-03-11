package com.calyrsoft.examplemvp

interface IContractLogin {
    interface View {
        fun showErrorUserName(message: String)
        fun showErrorPassword(message: String)
        fun showMessage(message: String)
    }

    interface Presenter {
        fun login(userName: String, password: String)
    }
}