package com.albuquerque.parrot.core.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.albuquerque.parrot.core.application.ParrotApplication
import com.albuquerque.parrot.core.session.SessionController

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ParrotApplication.database.authDAO().get().observe(this@BaseActivity, Observer { user ->
            user?.let { SessionController.updateUser(it) }

        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){

            android.R.id.home -> {
                onBackPressed()
                //finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

}