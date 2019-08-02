package com.albuquerque.parrot.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albuquerque.parrot.app.auth.dao.UserDAO
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.app.post.dao.PostsDAO
import com.albuquerque.parrot.app.post.model.Post

@Database(version = 3, entities = [User::class, Post::class])
abstract class AppDataBase: RoomDatabase() {

    abstract fun userDAO(): UserDAO

    abstract fun postsDAO(): PostsDAO

}