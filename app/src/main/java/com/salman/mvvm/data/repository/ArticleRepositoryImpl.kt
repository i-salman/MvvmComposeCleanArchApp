package com.salman.mvvm.data.repository

import com.salman.mvvm.data.remote.RemoteApi
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail
import com.salman.mvvm.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: RemoteApi
): ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return api.getArticles()
    }

    override suspend fun getArticleDetail(articleId: String): ArticleDetail {
        return api.getArticleDetail(articleId = articleId)
    }
}