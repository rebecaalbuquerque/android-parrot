package com.albuquerque.parrot.app.post.dao

import androidx.room.Dao
import androidx.room.Insert
import com.albuquerque.parrot.app.post.model.Post

@Dao
interface PostsDAO {

    @Insert
    suspend fun addAll(posts: MutableList<Post>)

}