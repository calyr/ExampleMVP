package com.calyrsoft.examplemvp

interface ILoginView {
    fun showErrorUserName(message: String)
    fun showErrorPassword(message: String)
    fun showMessage(message: String)
}