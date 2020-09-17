package com.jabezmagomere.news.data.local.datasource

import com.jabezmagomere.news.data.local.dao.NewsDao
import com.jabezmagomere.news.data.local.model.News
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun addNews(news: List<News>)
    fun getNewsBySection(section: String): Flow<List<News>>
}

class NewsLocalDataSourceImpl(private val newsDao: NewsDao) :
    NewsLocalDataSource {
    override suspend fun addNews(news: List<News>) = newsDao.insertAll(items = news)
    override fun getNewsBySection(section: String): Flow<List<News>> =
        newsDao.getNewsBySection(section)
}
