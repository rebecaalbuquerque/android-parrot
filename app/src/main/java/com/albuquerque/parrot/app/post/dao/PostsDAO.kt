package com.albuquerque.parrot.app.post.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.albuquerque.parrot.app.post.model.Post
import com.albuquerque.parrot.core.dao.BaseDAO

@Dao
interface PostsDAO: BaseDAO<Post> {

    /*@Query("SELECT * FROM posts WHERE id = :id")
    suspend fun get(id: Int)*/

    @Query("SELECT * FROM posts")
    fun getAll(): LiveData<List<Post>>

}