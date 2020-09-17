package com.jabezmagomere.news.data.remote.model

import com.jabezmagomere.news.data.local.model.News


data class NetworkResponse(val response: Response)

data class Response(
    val status: String,
    val userTier: String,
    val total: Int,
    val startIndex: Int,
    val pageSize: Int,
    val currentPage: Int,
    val pages: Int,
    val orderBy: String,
    val results: List<NewsResult>

)

fun Response.mapToNews(): List<News> = this.results.map { result ->
    News(
        apiUrl = result.apiUrl,
        thumbnail = result.fields?.thumbnail,
        wordCount = result.fields?.wordcount,
        id = result.id,
        isHosted = result.isHosted ?: false,
        sectionId = result.sectionId,
        sectionName = result.sectionName,
        type = result.type,
        webPublicationDate = result.webPublicationDate,
        webTitle = result.webTitle,
        webUrl = result.webUrl,
        trailText = result.fields?.trailText
    )
}

fun Response?.map(): List<News> {
    val news = mutableListOf<News>()
    this?.results?.forEach { result ->
        news.add(
            News(
                apiUrl = result.apiUrl,
                thumbnail = result.fields?.thumbnail,
                wordCount = result.fields?.wordcount,
                id = result.id,
                isHosted = result.isHosted ?: false,
                sectionId = result.sectionId,
                sectionName = result.sectionName,
                type = result.type,
                webPublicationDate = result.webPublicationDate,
                webTitle = result.webTitle,
                webUrl = result.webUrl,
                trailText = result.fields?.trailText
            )
        )
    }
    return news
}
