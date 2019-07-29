package com.albuquerque.parrot.app.auth.business

import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.app.auth.network.AuthNetwork

object AuthBusiness {

    fun doLogin(email: String, senha: String, onSuccess: (user: User) -> Unit, onError: (error: Throwable) -> Unit) {
        AuthNetwork.requestLogin(email, senha,
                {
                    onSuccess(it)
                },
                {
                    onError(it)
                }
        )
    }

}