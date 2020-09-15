package com.jabezmagomere.news.di

import android.app.Application
import androidx.room.Room
import com.jabezmagomere.news.data.local.NewsDatabase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    @NewsScope
    fun provideNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(application.baseContext, NewsDatabase::class.java, "news.db")
            .build()
    }

    @Provides
    @NewsScope
    fun provideNewsDao(newsDatabase: NewsDatabase) = newsDatabase.newsDao()
}