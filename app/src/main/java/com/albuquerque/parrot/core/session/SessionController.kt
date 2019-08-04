package com.albuquerque.parrot.core.session

import androidx.lifecycle.MutableLiveData
import com.albuquerque.parrot.app.auth.model.User

object SessionController {

    private var _user = MutableLiveData<User>()

    val user: User?
        get() = _user.value

    val token: String
        get() = user?.token ?: ""

    fun updateUser(user: User?) {
        _user.value = user
    }

}