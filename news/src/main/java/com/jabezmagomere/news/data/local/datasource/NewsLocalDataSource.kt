package com.jabezmagomere.news.data.local.datasource

import androidx.lifecycle.LiveData
import com.jabezmagomere.news.data.local.dao.NewsDao
import com.jabezmagomere.news.data.local.model.News
import javax.inject.Inject

interface NewsLocalDataSource {
    suspend fun addNews(news: List<News>)
    fun getNewsBySection(section: String): LiveData<List<News>>
}

class NewsLocalDataSourceImpl @Inject constructor(private val newsDao: NewsDao) :
    NewsLocalDataSource {
    override suspend fun addNews(news: List<News>) = newsDao.insertAll(items = news)
    override fun getNewsBySection(section: String): LiveData<List<News>> =
        newsDao.getNewsBySection(section = section)
}