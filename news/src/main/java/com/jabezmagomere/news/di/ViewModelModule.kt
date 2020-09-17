package com.jabezmagomere.news.di

import com.jabezmagomere.news.ui.newslist.viewmodel.NewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        NewsViewModel(get())
    }
}