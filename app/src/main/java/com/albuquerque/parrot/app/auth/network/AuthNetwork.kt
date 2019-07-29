package com.albuquerque.parrot.app.auth.network

import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.network.BaseNetwork

object AuthNetwork: BaseNetwork() {

    private val authAPI: AuthAPI by lazy {
        AuthNetwork.getRetrofitBuilder().build().create(AuthAPI::class.java)
    }

    fun requestLogin(email: String, senha: String, onSuccess: (user: User) -> Unit, onError: (error: Throwable) -> Unit){

        doRequest(authAPI, onSuccess, onError) {
            login(email, senha)
        }

    }

}