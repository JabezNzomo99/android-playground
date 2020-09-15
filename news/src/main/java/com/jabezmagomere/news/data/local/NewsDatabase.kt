package com.jabezmagomere.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jabezmagomere.news.data.local.dao.NewsDao
import com.jabezmagomere.news.data.local.model.News

@Database(entities = [News::class], exportSchema = false, version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}
