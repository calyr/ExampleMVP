package com.calyrsoft.examplemvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), IContractLogin.View {

    lateinit var loginPresenter: IContractLogin.Presenter
    override fun showErrorUserName(message: String) {
        username.error = message
    }

    override fun showErrorPassword(message: String) {
        password.error = message
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this, applicationContext)
    }

    fun loginOnClick(view: View) {
        loginPresenter.login(username.text.toString(), password.text.toString())
    }

    fun createOnClick(view: View) {
        navigateToCreateAccount()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        group.visibility = View.GONE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
        group.visibility = View.VISIBLE
    }

    override fun navigateToCreateAccount() {
        startActivity(Intent(this, CreateAccountActivity::class.java))
    }
}
