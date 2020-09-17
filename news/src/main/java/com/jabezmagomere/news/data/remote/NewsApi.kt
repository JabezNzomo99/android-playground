package com.jabezmagomere.news.data.remote

import com.jabezmagomere.news.BuildConfig
import com.jabezmagomere.news.data.remote.model.NetworkResponse
import com.jabezmagomere.news.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/search")
    suspend fun fetchNews(
        @Query("api-key") apiKey: String = BuildConfig.GUARDIAN_API_KEY,
        @Query("format") format: String = Constants.DATA_FORMAT,
        @Query("page-size") pageSize: Int = Constants.PAGE_SIZE,
        @Query("section") section: String,
        @Query("show-fields") fields: String = Constants.SHOW_FIELDS
    ): Response<NetworkResponse>
}
