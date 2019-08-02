package com.albuquerque.parrot.core.dao

import androidx.room.*

@Dao
interface BaseDAO<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<T>)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)

}