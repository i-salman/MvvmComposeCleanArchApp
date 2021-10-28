package com.nxb.mvvm.data.repository

import com.nxb.mvvm.common.ArticleDataFactory
import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleDataRepository (
    private val factory: ArticleDataFactory
): ArticleRepository {
    private fun getDataSource(): ArticleRepository {
        return factory.getRepository()
    }

    override suspend fun getArticles(): List<Article> {
        return getDataSource().getArticles()
    }

    override suspend fun getArticleDetail(articleId: String): Article {
        return getDataSource().getArticleDetail(articleId)
    }
}