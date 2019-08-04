package com.albuquerque.parrot.app.auth.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.albuquerque.parrot.app.auth.model.User
import com.albuquerque.parrot.core.dao.BaseDAO

@Dao
interface UserDAO: BaseDAO<User> {

    @Query("SELECT * FROM user")
    fun get(): LiveData<User>

}