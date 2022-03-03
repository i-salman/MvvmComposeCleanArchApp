package com.salman.mvvmcleanclean.data.repository

import com.salman.mvvmcleanclean.data.remote.RemoteApi
import com.salman.mvvmcleanclean.domain.model.Article
import com.salman.mvvmcleanclean.domain.model.ArticleDetail
import com.salman.mvvmcleanclean.domain.repository.ArticleRepository
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