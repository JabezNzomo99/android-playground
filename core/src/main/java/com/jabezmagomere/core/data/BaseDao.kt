package com.jabezmagomere.core.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: T)

    @Delete
    suspend fun clear()

    @Insert
    suspend fun insertAll(items: List<T>)

}