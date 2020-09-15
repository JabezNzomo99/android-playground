package com.jabezmagomere.news.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jabezmagomere.core.data.Result
import com.jabezmagomere.core.ui.UIState
import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSource
import com.jabezmagomere.news.data.local.model.News
import com.jabezmagomere.news.data.remote.NewsRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface NewsRepository {
    suspend fun fetchRemoteNews(section: String): LiveData<UIState>
    suspend fun getNewsBySection(section: String): LiveData<List<News>>
}

class NewsRepositoryImpl @Inject constructor(
    private val newsLocalDataSource: NewsLocalDataSource,
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
) : NewsRepository {
    override suspend fun fetchRemoteNews(section: String): LiveData<UIState> = liveData {
        return@liveData when (val result = newsRemoteDataSource.fetchNews(section)) {
            is Result.Loading -> emit(UIState.Loading)
            is Result.Success -> {
                val news = result.data
                newsLocalDataSource.addNews(news)
                emit(UIState.Success(true))
            }
            is Result.Error -> {
                val error = result.exception
                emit(UIState.Error(error))
            }
        }

    }

    override suspend fun getNewsBySection(section: String): LiveData<List<News>> =
        newsLocalDataSource.getNewsBySection(section = section)


}