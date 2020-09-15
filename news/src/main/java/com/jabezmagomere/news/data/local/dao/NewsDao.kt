package com.jabezmagomere.news.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.jabezmagomere.core.data.BaseDao
import com.jabezmagomere.news.data.local.model.News

@Dao
interface NewsDao : BaseDao<News> {

    @Query("SELECT * FROM News WHERE sectionName=:section")
    fun getNewsBySection(section: String): LiveData<List<News>>

    @Query("DELETE FROM News")
    suspend fun clearNews()
}