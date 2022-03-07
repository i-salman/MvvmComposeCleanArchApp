package com.salman.mvvmclean.data.repository

import com.salman.mvvmclean.data.remote.RemoteApi
import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: RemoteApi
): ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return api.getArticles()
    }
}