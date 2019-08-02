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
                    posts.forEach {
                        if(it.imagem?.contains("missing.png") == false)
                            it.imagem = BaseNetwork.BASE_URL2 + it.imagem
                        else
                            it.imagem = null
                    }

                    launch {

                        withContext(Dispatchers.IO) {
                            ParrotApplication.database.postsDAO().insertAll(posts)
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