package com.albuquerque.parrot.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albuquerque.parrot.app.auth.dao.AuthDAO
import com.albuquerque.parrot.app.user.dao.UserDAO
import com.albuquerque.parrot.app.auth.model.Auth
import com.albuquerque.parrot.app.user.model.User
import com.albuquerque.parrot.app.post.dao.PostsDAO
import com.albuquerque.parrot.app.post.model.Post

@Database(version = 1, entities = [User::class, Post::class, Auth::class])
abstract class AppDataBase: RoomDatabase() {

    abstract fun userDAO(): UserDAO

    abstract fun postsDAO(): PostsDAO

    abstract fun authDAO(): AuthDAO

}