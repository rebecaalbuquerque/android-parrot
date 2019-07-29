package com.albuquerque.parrot.app.auth.network

import com.albuquerque.parrot.app.auth.model.User
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthAPI {

    @FormUrlEncoded
    @POST("usuario/login")
    fun login(
            @Field("email") email: String,
            @Field("password") password: String
    ): Observable<User>

}