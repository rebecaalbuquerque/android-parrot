package com.albuquerque.parrot.app.viewmodel

import androidx.lifecycle.ViewModel
import com.albuquerque.parrot.app.model.User
import com.albuquerque.parrot.core.livedata.SingleLiveEvent

class AuthViewModel: ViewModel() {

    val user = User()

    val onInputEmpty = SingleLiveEvent<Void>()

    fun login() {

        if(user.email.isEmpty() || user.senha.isEmpty()) {
            onInputEmpty.call()
            return
        }

        user

    }

}