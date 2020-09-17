package com.jabezmagomere.news.data.remote

import com.jabezmagomere.core.data.Result
import com.jabezmagomere.news.data.local.model.News
import com.jabezmagomere.news.data.remote.model.map

interface NewsRemoteDataSource {
    suspend fun fetchNews(section: String): Result<List<News>?>
}

class NewsRemoteDataSourceImpl(private val newsApi: NewsApi) :
    NewsRemoteDataSource {
    override suspend fun fetchNews(section: String): Result<List<News>?> {
        return try {
            val newsResponse = newsApi.fetchNews(section = section)
            if (newsResponse.isSuccessful && newsResponse.body() != null) {
                Result.Success(newsResponse.body()?.response.map())
            } else {
                Result.Error(Exception())
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
