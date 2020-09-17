package com.jabezmagomere.news.di

import com.google.gson.Gson
import com.jabezmagomere.news.data.remote.NewsApi
import com.jabezmagomere.news.data.remote.NewsRemoteDataSource
import com.jabezmagomere.news.data.remote.NewsRemoteDataSourceImpl
import com.jabezmagomere.news.util.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteDataSourceModule = module {
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
    fun provideNewsRemoteDataSource(newsApi: NewsApi): NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(newsApi)
    single { provideRetrofit(get(), get()) }
    single { provideNewsApi(get()) }
    single { provideNewsRemoteDataSource(get()) }
}