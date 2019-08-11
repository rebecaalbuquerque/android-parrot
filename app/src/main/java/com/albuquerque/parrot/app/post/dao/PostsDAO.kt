package com.albuquerque.parrot.app.post.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.app.post.model.PostUser
import com.albuquerque.parrot.core.application.ParrotApplication
import com.albuquerque.parrot.core.dao.BaseDAO

@Dao
interface PostsDAO: BaseDAO<Post> {

    @Query("SELECT * FROM posts INNER JOIN user ON user.id = userId")
    fun getAll(): LiveData<List<PostUser>>

    @Query("SELECT * FROM posts INNER JOIN user ON user.id = userId WHERE userId = :id")
    fun getAll(id: Int): LiveData<List<PostUser>>

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