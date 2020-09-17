package com.jabezmagomere.news.ui.newslist.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.jabezmagomere.news.R
import com.jabezmagomere.news.di.*
import com.jabezmagomere.news.ui.newslist.adapter.NewsAdapter
import com.jabezmagomere.news.ui.newslist.viewmodel.NewsViewModel
import com.jabezmagomere.news.util.Constants
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeatures by lazy {
    loadKoinModules(
        listOf(
            databaseModule,
            localDataSourceModules,
            remoteDataSourceModule,
            repositoryModule,
            viewModelModule
        )
    )
}

private fun injectFeatures() = loadFeatures

/**
 * News Fragment
 */
class NewsFragment : Fragment() {

    private val newsViewModel: NewsViewModel by viewModel()
    private val newsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onAttach(context: Context) {
        injectFeatures()
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRvAdapter()
        observeNews()
        fetchRemoteNews()
    }

    private fun setUpRvAdapter() {
        rvNews.adapter = newsAdapter
    }

    private fun fetchRemoteNews() {
        swipeRefresh.setOnRefreshListener {
            newsViewModel.fetchNews(Constants.SPORTS).observe(viewLifecycleOwner, Observer {

            })
        }
    }

    private fun observeNews() {
        newsViewModel.getNews(Constants.SPORTS).observe(viewLifecycleOwner, Observer { news ->
            newsAdapter.submitList(news)
        })
    }

}
