package com.albuquerque.parrot.app.auth.dao

import androidx.room.*
import com.albuquerque.parrot.app.auth.model.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM user")
    suspend fun findFirst(): User?

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

}