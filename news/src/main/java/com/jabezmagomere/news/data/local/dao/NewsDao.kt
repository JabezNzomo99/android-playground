package com.jabezmagomere.news.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jabezmagomere.core.data.BaseDao
import com.jabezmagomere.news.data.local.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao : BaseDao<News> {

    @Query("SELECT * FROM News WHERE sectionId=:section ORDER BY webPublicationDate DESC")
    fun getNewsBySection(section: String): Flow<List<News>>

    @Query("DELETE FROM News")
    suspend fun clearNews()
}
