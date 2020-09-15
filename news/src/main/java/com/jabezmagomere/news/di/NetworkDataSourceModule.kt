package com.jabezmagomere.news.di

import com.jabezmagomere.news.data.remote.NewsApi
import com.jabezmagomere.news.data.remote.NewsRemoteDataSource
import com.jabezmagomere.news.data.remote.NewsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
object NetworkDataSourceModule {
    @Binds
    @NewsScope
    fun provideNetworkDataSource(newsApi: NewsApi): NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(newsApi = newsApi)
}
