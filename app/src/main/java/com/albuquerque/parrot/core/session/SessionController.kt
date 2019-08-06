package com.albuquerque.parrot.core.session

import androidx.lifecycle.MutableLiveData
import com.albuquerque.parrot.app.auth.model.Auth

object SessionController {

    private var _user = MutableLiveData<Auth>()

    val user: Auth?
        get() = _user.value

    val token: String
        get() = user?.token ?: ""

    fun updateUser(user: Auth?) {
        _user.value = user
    }

}