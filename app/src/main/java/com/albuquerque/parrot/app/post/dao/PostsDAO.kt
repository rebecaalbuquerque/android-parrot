package com.albuquerque.parrot.app.post.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.application.ParrotApplication
import com.albuquerque.parrot.core.dao.BaseDAO
import com.albuquerque.parrot.core.session.SessionController

@Dao
interface PostsDAO: BaseDAO<Post> {

    @Query("SELECT * FROM posts")
    fun getAll(): LiveData<List<Post>>

    @Transaction
    suspend fun insertPosts(posts: List<Post>) {
        posts.forEach { post ->

            post.autor?.let { autor ->

                post.userId = autor.id

                with(ParrotApplication.database) {
                    userDAO().insert(autor)
                    postsDAO().insert(post)
                }

            }
        }
    }

}