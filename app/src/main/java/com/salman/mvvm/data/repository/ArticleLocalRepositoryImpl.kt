package com.salman.mvvm.data.repository

import com.salman.mvvm.data.local.ArticleDao
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail
import com.salman.mvvm.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleLocalRepositoryImpl @Inject constructor(
    private val articleDao: ArticleDao
) : ArticleRepository {

    override suspend fun getArticles(): List<Article> {
        return articleDao.getArticles()
    }

    override suspend fun getArticleDetail(articleId: String): Article {
        return articleDao.getArticleDetail(articleId)
    }
}