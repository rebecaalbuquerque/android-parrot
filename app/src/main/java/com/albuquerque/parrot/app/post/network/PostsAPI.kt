package com.albuquerque.parrot.app.post.network

import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.network.BaseNetwork
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface PostsAPI {

    @GET("")
    fun fetchPosts(
        @Header(BaseNetwork.HEADER_TOKEN) token: String
    ): Observable<MutableList<Post>>

}