package com.calyrsoft.examplemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        setSupportActionBar(toolbar)
        supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
            it?.setDisplayShowHomeEnabled(true)
            title = getString(R.string.login_activity_name)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_account, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
            R.id.setting_menu_item -> {
                Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show()
                true
            }
           else -> {
                super.onOptionsItemSelected(item)
           }
       }
    }
}
