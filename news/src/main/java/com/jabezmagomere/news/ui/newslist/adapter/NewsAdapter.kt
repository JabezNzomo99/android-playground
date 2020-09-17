package com.jabezmagomere.news.ui.newslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.jabezmagomere.core.util.getTimeDiffFromStringTime
import com.jabezmagomere.core.util.show
import com.jabezmagomere.news.R
import com.jabezmagomere.news.data.local.model.News
import com.jabezmagomere.news.util.Constants
import kotlinx.android.synthetic.main.row_news_item.view.*

class NewsAdapter : ListAdapter<News, NewsAdapter.NewsViewHolder>(DIFF_CALLBACK) {
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: News) {
            itemView.textViewNewsHeader.text = news.webTitle
            itemView.textViewTrailText.text = news.trailText
            itemView.textViewSectionName.text = news.sectionName
            itemView.textViewTimeLapse.text = news.webPublicationDate?.getTimeDiffFromStringTime(
                Constants.dateTimeFormat,
                itemView.context
            )
            news.wordCount?.toInt()?.let { count ->
                itemView.chipTimeDuration.show()
                itemView.chipTimeDuration.text =
                    String.format("%d %s", (count.div(200)), "minutes Read")
            }
            itemView.imageViewNewsThumbnail.load(news.thumbnail) {
                crossfade(true)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_news_item, parent, false)
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem == newItem
        }
    }
}