package com.calyrsoft.examplemvp

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), IContractLogin.View {

    fun isConexion( context: Context) : Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

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

        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("the best seller: Android"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST","Id book = ${it.id}, Title: ${it.title}")
            }
        }

        print("${session.isLogin}")
        Log.d("VALOR DE LA SESSION",  session.isLogin.toString() )

        profile_text_view.setOnClickListener {
            if( session.isLogin ) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Acceso no permitido", Toast.LENGTH_LONG).show()
            }

            if(isConexion(applicationContext)) {
                Toast.makeText(this, "Tiene acceso a internet", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No tiene acceso a internet", Toast.LENGTH_LONG).show()
            }


        }
    }

    fun loginOnClick(view: View) {
        loginPresenter.login(username.editText?.text.toString(), password.editText?.text.toString())
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

    override fun goToProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }
}
