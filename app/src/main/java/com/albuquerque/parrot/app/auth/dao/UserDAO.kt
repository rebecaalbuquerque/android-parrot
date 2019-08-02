package com.albuquerque.parrot.app.auth.dao

import androidx.room.*
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.dao.BaseDAO

@Dao
interface UserDAO: BaseDAO<User> {

    @Query("SELECT * FROM user")
    suspend fun get(): User?

}