package com.albuquerque.parrot.app.register.viewmodel

import androidx.lifecycle.ViewModel
import com.albuquerque.parrot.app.auth.model.User

class RegisterViewModel: ViewModel()  {

    val user = User()

    fun register() {

        user

    }

}