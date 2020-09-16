package com.jabezmagomere.news.ui.newslist.viewmodel

import androidx.lifecycle.*
import com.jabezmagomere.core.ui.UIState
import com.jabezmagomere.news.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private var _uiState = MutableLiveData<UIState>()
    val uiState: LiveData<UIState>
        get() = _uiState

    private fun getNews(section: String) = liveData {
        emitSource(newsRepository.getNewsBySection(section))
    }

    private fun fetchNews(section: String) = viewModelScope.launch {
        _uiState.postValue(newsRepository.fetchRemoteNews(section = section).value)
    }
}