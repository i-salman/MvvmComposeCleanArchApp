package com.nxb.mvvm.data.repository

import com.nxb.mvvm.data.local.ArticleDao
import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.model.ArticleDetail
import com.nxb.mvvm.domain.repository.ArticleRepository
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