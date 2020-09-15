package com.jabezmagomere.news.di

import com.jabezmagomere.news.data.local.dao.NewsDao
import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSource
import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
object LocalDataSourceModule {
    @Binds
    @NewsScope
    fun provideNewsLocalDataSource(newsDao: NewsDao): NewsLocalDataSource =
        NewsLocalDataSourceImpl(newsDao = newsDao)
}
