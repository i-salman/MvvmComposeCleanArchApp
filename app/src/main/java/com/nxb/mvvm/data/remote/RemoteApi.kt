package com.nxb.mvvm.data.remote

import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.model.ArticleDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/v3/articles")
    suspend fun getArticles(): List<Article>

    @GET("/v3/articles/{articleId}")
    suspend fun getArticleDetail(@Path("articleId") articleId: String): ArticleDetail

}