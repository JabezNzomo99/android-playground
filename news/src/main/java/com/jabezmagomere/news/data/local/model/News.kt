package com.jabezmagomere.news.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class News(
    @PrimaryKey
    val newsId: Int = 0,
    val apiUrl: String?,
    val thumbnail: String?,
    val wordCount: String?,
    val id: String?,
    val isHosted: Boolean = false,
    val sectionId: String?,
    val sectionName: String?,
    val type: String?,
    val webPublicationDate: String?,
    val webTitle: String?,
    val webUrl: String?
)
