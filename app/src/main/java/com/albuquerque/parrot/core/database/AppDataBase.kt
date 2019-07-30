package com.albuquerque.parrot.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albuquerque.parrot.app.auth.dao.UserDAO
import com.albuquerque.parrot.app.auth.model.User

@Database(version = 3, entities = [User::class])
abstract class AppDataBase: RoomDatabase() {

    abstract fun userDAO(): UserDAO

}