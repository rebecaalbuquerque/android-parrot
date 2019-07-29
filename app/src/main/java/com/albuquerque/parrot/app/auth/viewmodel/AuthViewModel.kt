package com.albuquerque.parrot.app.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.livedata.SingleLiveEvent
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.albuquerque.parrot.app.auth.business.AuthBusiness
import com.albuquerque.parrot.app.auth.network.AuthNetwork


class AuthViewModel: ViewModel() {

    var email = ObservableField<String>()
    var senha = ObservableField<String>()

    val onLoginSuccess = SingleLiveEvent<Void>()

    fun login() {

        if(email.get() != null && senha.get() != null) {

            AuthBusiness.doLogin(email.get().toString(), senha.get().toString(),
                    {
                        onLoginSuccess.call()
                    },
                    {
                        it
                    }
            )
        }

    }

}