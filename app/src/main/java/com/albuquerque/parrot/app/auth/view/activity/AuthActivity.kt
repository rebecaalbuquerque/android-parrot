package com.albuquerque.parrot.app.auth.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.auth.viewmodel.AuthViewModel
import com.albuquerque.parrot.app.post.activity.PostsActivity
import com.albuquerque.parrot.app.register.view.activity.RegisterActivity
import com.albuquerque.parrot.databinding.ActivityAuthBinding
import kotlinx.android.synthetic.main.activity_auth.*
import org.jetbrains.anko.startActivity

class AuthActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        setupDataBinding()
        setupView()
        subscribeUI()

    }

    private fun setupDataBinding() {
        with(binding) {
            lifecycleOwner = this@AuthActivity
            viewModel = authViewModel
            executePendingBindings()
        }
    }

    private fun setupView() {

        buttonLogin.setOnClickListener {
            authViewModel.login()
        }

        signUp.setOnClickListener {
            startActivity<RegisterActivity>()
        }

    }

    private fun subscribeUI() {

        with(authViewModel) {

            onLoginSuccess.observe(this@AuthActivity, Observer {
                startActivity<PostsActivity>()
            })

        }

    }
}
