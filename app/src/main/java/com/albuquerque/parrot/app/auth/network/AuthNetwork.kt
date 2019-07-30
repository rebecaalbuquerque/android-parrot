package com.albuquerque.parrot.app.auth.network

import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.network.BaseNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthNetwork: BaseNetwork() {

    private val authAPI: AuthAPI by lazy {
        AuthNetwork.getRetrofitBuilder().build().create(AuthAPI::class.java)
    }

    fun requestLogin(email: String, senha: String, onSuccess: (response: Response<User>) -> Unit, onError: (error: Throwable) -> Unit){

        authAPI.login(email, senha).enqueue(object : Callback<User>{

            override fun onResponse(call: Call<User>, response: Response<User>) {

                if(response.isSuccessful)
                    onSuccess(response)
                else
                    onError(Throwable())

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onError(t)
            }

        })

    }

}