package com.salman.mvvmclean.data.repository

import com.salman.mvvmclean.data.local.ArticleDao
import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.model.ArticleDetail
import com.salman.mvvmclean.domain.repository.ArticleRepository
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