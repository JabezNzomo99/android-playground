package com.jabezmagomere.news.data.remote.model

import com.jabezmagomere.news.data.local.model.News

data class NewsResponse(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val result: List<NewsResult>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String

)

fun NewsResponse.mapToNews(): List<News> = this.result.map { result ->
    News(
        apiUrl = result.apiUrl,
        thumbnail = result.fields.thumbnail,
        wordCount = result.fields.wordcount,
        id = result.id,
        isHosted = result.isHosted,
        sectionId = result.sectionId,
        sectionName = result.sectionName,
        type = result.type,
        webPublicationDate = result.webPublicationDate,
        webTitle = result.webTitle,
        webUrl = result.webUrl
    )
}