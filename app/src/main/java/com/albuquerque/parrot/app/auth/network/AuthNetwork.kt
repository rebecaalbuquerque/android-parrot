package com.albuquerque.parrot.app.auth.network

import com.albuquerque.parrot.app.auth.model.Auth
import com.albuquerque.parrot.core.network.BaseNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthNetwork: BaseNetwork() {

    private val authAPI: AuthAPI by lazy {
        AuthNetwork.getRetrofitBuilder().build().create(AuthAPI::class.java)
    }

    fun requestLogin(email: String, senha: String, onSuccess: (response: Response<Auth>) -> Unit, onError: (error: Throwable) -> Unit){

        authAPI.login(email, senha).enqueue(object : Callback<Auth>{

            override fun onResponse(call: Call<Auth>, response: Response<Auth>) {

                if(response.isSuccessful)
                    onSuccess(response)
                else
                    onError(Throwable())

            }

            override fun onFailure(call: Call<Auth>, t: Throwable) {
                onError(t)
            }

        })

    }

}