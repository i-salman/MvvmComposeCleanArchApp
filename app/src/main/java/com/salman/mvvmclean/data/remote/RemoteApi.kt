package com.salman.mvvmclean.data.remote

import com.salman.mvvmclean.domain.model.Article
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/v3/articles")
    suspend fun getArticles(): List<Article>
}