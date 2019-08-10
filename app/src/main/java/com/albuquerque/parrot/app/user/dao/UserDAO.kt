package com.albuquerque.parrot.app.user.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.albuquerque.parrot.app.user.model.User
import com.albuquerque.parrot.core.dao.BaseDAO

@Dao
interface UserDAO: BaseDAO<User> {

    @Query("SELECT * FROM user")
    fun get(): LiveData<User>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun get(id: Int): User?

}