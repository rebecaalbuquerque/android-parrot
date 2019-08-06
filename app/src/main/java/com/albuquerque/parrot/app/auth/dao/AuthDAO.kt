package com.albuquerque.parrot.app.auth.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.albuquerque.parrot.app.auth.model.Auth
import com.albuquerque.parrot.core.dao.BaseDAO

@Dao
interface AuthDAO: BaseDAO<Auth> {

    @Query("SELECT * FROM auth")
    fun get(): LiveData<Auth>

}