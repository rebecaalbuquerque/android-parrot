package com.albuquerque.parrot.app.post.network

import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.network.BaseNetwork

object PostsNetwork : BaseNetwork() {

    private val postsAPI: PostsAPI by lazy {
        PostsNetwork.getRetrofitBuilder().build().create(PostsAPI::class.java)
    }

    fun requestPosts(token: String, onSuccess: (posts: MutableList<Post>) -> Unit, onError: (error: Throwable) -> Unit) {
        doRequest(postsAPI, onSuccess, onError) {
            fetchPosts(token)
        }
    }

}