package com.calyrsoft.examplemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginView {

    lateinit var loginPresenter: ILoginPresenter
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
    }

    fun loginOnClick(view: View) {

    }
}
