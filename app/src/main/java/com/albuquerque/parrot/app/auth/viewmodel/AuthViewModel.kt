package com.albuquerque.parrot.app.auth.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.albuquerque.parrot.app.auth.business.AuthBusiness
import com.albuquerque.parrot.core.livedata.SingleLiveEvent
import com.albuquerque.parrot.core.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class AuthViewModel: BaseViewModel() {

    var email = ObservableField<String>()
    var senha = ObservableField<String>()

    val onLoginSuccess = SingleLiveEvent<Void>()

    init {
        viewModelScope.launch {
            if(database.userDAO().findFirst() != null)
                onLoginSuccess.call()
        }
    }

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