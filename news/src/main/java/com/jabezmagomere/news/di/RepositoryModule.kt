package com.jabezmagomere.news.di

import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSource
import com.jabezmagomere.news.data.remote.NewsRemoteDataSource
import com.jabezmagomere.news.data.repository.NewsRepository
import com.jabezmagomere.news.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
object RepositoryModule {

    @Binds
    @NewsScope
    fun provideNewsRepository(
        newsLocalDataSource: NewsLocalDataSource,
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository = NewsRepositoryImpl(
        newsLocalDataSource = newsLocalDataSource,
        newsRemoteDataSource = newsRemoteDataSource
    )
}
