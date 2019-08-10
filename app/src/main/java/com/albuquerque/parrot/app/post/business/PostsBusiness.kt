package com.albuquerque.parrot.app.post.business

import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.app.post.network.PostsNetwork
import com.albuquerque.parrot.core.application.ParrotApplication
import com.albuquerque.parrot.core.network.BaseNetwork
import kotlinx.coroutines.*

object PostsBusiness: CoroutineScope by MainScope() {

    fun getPostsFromAPI(onSuccess: (posts: MutableList<Post>) -> Unit, onError: (error: Throwable) -> Unit) {

        PostsNetwork.requestPosts(
                { posts ->
                    posts.forEach { post ->

                        post.imagem?.let {

                            if(!it.contains("/images/original/missing.png"))
                                post.imagem = BaseNetwork.BASE_URL2 + post.imagem
                            else
                                post.imagem = null

                        }

                    }

                    launch {

                        withContext(Dispatchers.IO) {
                            ParrotApplication.database.postsDAO().insertPosts(posts)
                        }

                        onSuccess(posts)

                    }
                },
                {
                    onError(it)
                }
        )

    }

}