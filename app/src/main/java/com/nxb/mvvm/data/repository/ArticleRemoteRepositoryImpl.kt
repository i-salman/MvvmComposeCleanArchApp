package com.salman.mvvm.data.repository

import android.util.Log
import com.salman.mvvm.data.local.ArticleDao
import com.salman.mvvm.data.remote.RemoteApi
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail
import com.salman.mvvm.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
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