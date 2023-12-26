package com.example.thenewsapp.repository

import com.example.thenewsapp.api.RetrofitInstance
import com.example.thenewsapp.db.ArticleDatabase
import com.example.thenewsapp.models.Article
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(contryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(contryCode, pageNumber)

    suspend fun searchNews(searhQuery: String, pageNumber: Int) =
        RetrofitInstance.api.seacrhForNews(searhQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticlesDao().upsert(article)

    fun getFavoritesNews() = db.getArticlesDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticlesDao().deleteArticle(article)
}