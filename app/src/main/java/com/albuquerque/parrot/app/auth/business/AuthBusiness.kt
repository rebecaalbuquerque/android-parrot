package com.albuquerque.parrot.app.auth.business

import com.albuquerque.parrot.app.auth.network.AuthNetwork
import com.albuquerque.parrot.core.application.ParrotApplication
import com.albuquerque.parrot.core.network.BaseNetwork.Companion.HEADER_TOKEN
import kotlinx.coroutines.*

object AuthBusiness: CoroutineScope by MainScope() {

    fun doLogin(email: String, senha: String, onSuccess: () -> Unit, onError: (error: Throwable) -> Unit) {
        AuthNetwork.requestLogin(email, senha,
                { response ->

                    val user = response.body()?.apply {
                        token = response.headers()[HEADER_TOKEN]
                    }!!

                    launch {

                        withContext(Dispatchers.IO) {
                            ParrotApplication.database.userDAO().insertUser(user)
                        }

                        onSuccess()

                    }


                },
                {
                    onError(it)
                }
        )
    }

}