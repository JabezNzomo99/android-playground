package com.jabezmagomere.news.data.repository

import com.jabezmagomere.core.data.Result
import com.jabezmagomere.core.ui.UIState
import com.jabezmagomere.news.data.local.datasource.NewsLocalDataSource
import com.jabezmagomere.news.data.local.model.News
import com.jabezmagomere.news.data.remote.NewsRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface NewsRepository {
    suspend fun fetchRemoteNews(section: String): Flow<UIState>
    suspend fun getNewsBySection(section: String): Flow<List<News>>
}

class NewsRepositoryImpl(
    private val newsLocalDataSource: NewsLocalDataSource,
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
) : NewsRepository {
    override suspend fun fetchRemoteNews(section: String): Flow<UIState> = flow {
        emit(UIState.Loading)
        when (val result = newsRemoteDataSource.fetchNews(section)) {
            is Result.Success -> {
                val news = result.data
                news?.let {
                    newsLocalDataSource.addNews(news)
                }
                emit(UIState.Success(true))
            }
            is Result.Error -> {
                val error = result.exception
                emit(UIState.Error(error))
            }
        }
    }.flowOn(dispatcherIO)

    override suspend fun getNewsBySection(section: String): Flow<List<News>> =
        newsLocalDataSource.getNewsBySection(section = section)
}
