package com.albuquerque.parrot.app.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.livedata.SingleLiveEvent

class AuthViewModel: ViewModel() {

    val user = User()

    fun login() {

        user

    }

}