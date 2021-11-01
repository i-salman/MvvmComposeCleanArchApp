package com.nxb.mvvm.data.repository

import android.util.Log
import com.nxb.mvvm.data.local.ArticleDao
import com.nxb.mvvm.data.remote.RemoteApi
import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.model.ArticleDetail
import com.nxb.mvvm.domain.repository.ArticleRepository
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