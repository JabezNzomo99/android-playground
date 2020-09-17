package com.jabezmagomere.news.di

import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSource
import com.jabezmagomere.news.data.remote.NewsRemoteDataSource
import com.jabezmagomere.news.data.repository.NewsRepository
import com.jabezmagomere.news.data.repository.NewsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    fun provideNewsRepository(
        newsLocalDataSource: NewsLocalDataSource,
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository = NewsRepositoryImpl(newsLocalDataSource, newsRemoteDataSource)
    single {
        provideNewsRepository(get(), get())
    }
}