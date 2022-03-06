package com.salman.mvvmclean.data.repository

import com.salman.mvvmclean.common.ArticleDataFactory
import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.repository.ArticleRepository
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