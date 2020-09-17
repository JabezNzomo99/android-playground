package com.jabezmagomere.news.data.remote.model

data class NewsResult(
    val apiUrl: String?,
    val fields: Fields?,
    val id: String?,
    val isHosted: Boolean?,
    val pillarId: String?,
    val pillarName: String?,
    val sectionId: String?,
    val sectionName: String?,
    val type: String?,
    val webPublicationDate: String?,
    val webTitle: String?,
    val webUrl: String?
)
