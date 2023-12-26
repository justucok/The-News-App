package com.example.thenewsapp.api

import com.example.thenewsapp.models.NewsResponse
import com.example.thenewsapp.utils.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey
import java.util.Locale.IsoCountryCode

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("county")
        countryCode: String = "id",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun seacrhForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

}