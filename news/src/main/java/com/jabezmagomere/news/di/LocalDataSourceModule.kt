package com.jabezmagomere.news.di

import com.jabezmagomere.news.data.local.dao.NewsDao
import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSource
import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSourceImpl
import org.koin.dsl.module

val localDataSourceModules = module {
    fun provideNewsLocalDataSource(newsDao: NewsDao): NewsLocalDataSource =
        NewsLocalDataSourceImpl(newsDao)
    single {
        provideNewsLocalDataSource(get())
    }
}