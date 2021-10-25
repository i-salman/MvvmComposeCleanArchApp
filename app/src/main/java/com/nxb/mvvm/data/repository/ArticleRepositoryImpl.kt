package com.nxb.mvvm.data.repository

import com.nxb.mvvm.data.remote.RemoteApi
import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.model.ArticleDetail
import com.nxb.mvvm.domain.repository.ArticleRepository
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