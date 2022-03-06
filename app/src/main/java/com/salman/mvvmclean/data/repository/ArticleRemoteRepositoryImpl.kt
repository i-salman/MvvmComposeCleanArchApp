package com.salman.mvvmclean.data.repository

import com.salman.mvvmclean.data.local.ArticleDao
import com.salman.mvvmclean.data.remote.RemoteApi
import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRemoteRepositoryImpl @Inject constructor(
    private val api: RemoteApi,
    private val articleDao: ArticleDao
): ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        val articles = api.getArticles()
        insertArticlesToLocalDb(articles)
        return articles
    }

    override suspend fun getArticleDetail(articleId: String): Article{
        return api.getArticleDetail(articleId = articleId)
    }

    private suspend fun insertArticlesToLocalDb(articles: List<Article>) {
        articleDao.insertArticles(articles)
    }

}