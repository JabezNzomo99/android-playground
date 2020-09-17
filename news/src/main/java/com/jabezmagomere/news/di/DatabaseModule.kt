package com.jabezmagomere.news.di

import android.content.Context
import androidx.room.Room
import com.jabezmagomere.news.data.local.NewsDatabase
import com.jabezmagomere.news.data.local.dao.NewsDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    fun provideNewsDatabase(context: Context): NewsDatabase =
        Room.databaseBuilder(context, NewsDatabase::class.java, "news.db").build()

    fun provideNewsDao(database: NewsDatabase): NewsDao = database.newsDao()

    single { provideNewsDatabase(androidContext()) }
    single { provideNewsDao(get()) }
}