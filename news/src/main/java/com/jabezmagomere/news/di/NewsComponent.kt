package com.jabezmagomere.news.di

import com.jabezmagomere.news.ui.newsdetail.view.NewsDetailFragment
import com.jabezmagomere.news.ui.newslist.view.NewsFragment
import dagger.Component

@Component(modules = [DatabaseModule::class, NetworkModule::class, ViewModelModule::class, LocalDataSourceModule::class, NetworkDataSourceModule::class, RepositoryModule::class])
@NewsScope
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
    fun inject(newsDetailFragment: NewsDetailFragment)
}