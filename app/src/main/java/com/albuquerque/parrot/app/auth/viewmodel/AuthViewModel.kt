package com.albuquerque.parrot.app.auth.viewmodel

import androidx.databinding.ObservableField
import com.albuquerque.parrot.app.auth.business.AuthBusiness
import com.albuquerque.parrot.core.livedata.SingleLiveEvent
import com.albuquerque.parrot.core.viewmodel.BaseViewModel

class AuthViewModel: BaseViewModel() {

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
                        onError.call()
                    }
            )
        }

    }

}