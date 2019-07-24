package com.albuquerque.parrot.app.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.albuquerque.parrot.core.livedata.SingleLiveEvent

class AuthViewModel: ViewModel() {

    // Abstração da tela de login. Serão observados pela view
    val email = ObservableField<String>()
    val senha = ObservableField<String>()

    val loadingState = ObservableBoolean()

    val onInputEmpty = SingleLiveEvent<Void>()


    fun login() {

        if(email.get().isNullOrEmpty() || senha.get().isNullOrEmpty())
            onInputEmpty.call()

        loadingState.set(true)
        // request
            // onSuccess: .set(false)
            // onError: .set(false)

    }

}