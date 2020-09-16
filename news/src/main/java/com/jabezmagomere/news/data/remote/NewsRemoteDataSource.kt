package com.jabezmagomere.news.data.remote

import com.jabezmagomere.core.data.Result
import com.jabezmagomere.news.data.local.model.News
import com.jabezmagomere.news.data.remote.model.mapToNews
import javax.inject.Inject

interface NewsRemoteDataSource {
    suspend fun fetchNews(section: String): Result<List<News>>
}

class NewsRemoteDataSourceImpl @Inject constructor(private val newsApi: NewsApi) :
    NewsRemoteDataSource {
    override suspend fun fetchNews(section: String): Result<List<News>> {
        return try {
            Result.Loading
            val newsResponse = newsApi.fetchNews(section = section)
            Result.Success(newsResponse.mapToNews())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
