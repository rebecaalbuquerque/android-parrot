package com.albuquerque.parrot.app.post.network

import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.network.BaseNetwork
import com.albuquerque.parrot.core.session.SessionController
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface PostsAPI {

    @GET("/postagem")
    fun fetchPosts(
        @Header(BaseNetwork.HEADER_TOKEN) token: String = SessionController.user?.token ?: ""
    ): Observable<MutableList<Post>>

}