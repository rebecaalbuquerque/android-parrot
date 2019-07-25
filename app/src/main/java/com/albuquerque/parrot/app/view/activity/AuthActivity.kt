package com.albuquerque.parrot.app.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.viewmodel.AuthViewModel
import com.albuquerque.parrot.databinding.ActivityAuthBinding
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        binding.lifecycleOwner = this
        binding.viewModel = authViewModel
        binding.executePendingBindings()

        setupView()
        subscribeUI()

    }

    private fun setupView() {
        buttonLogin.setOnClickListener {
            authViewModel.login()
        }
    }

    private fun subscribeUI() {

        with(authViewModel) {

            onInputEmpty.observe(this@AuthActivity, Observer {
                layoutEmail.error = getString(R.string.hint_error)
                layoutSenha.error = getString(R.string.hint_error)
            })

        }

    }
}
