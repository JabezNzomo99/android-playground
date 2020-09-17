package com.jabezmagomere.news.ui.newslist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.jabezmagomere.core.ui.UIState
import com.jabezmagomere.news.data.local.model.News
import com.jabezmagomere.news.data.repository.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    fun getNews(section: String): LiveData<List<News>> = liveData {
        emitSource(newsRepository.getNewsBySection(section).asLiveData())
    }

    fun fetchNews(section: String): LiveData<UIState> = liveData {
        emitSource(newsRepository.fetchRemoteNews(section).asLiveData())
    }
}