package com.nxb.mvvm.domain.repository

import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.model.ArticleDetail
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    suspend fun getArticles(): List<Article>

    suspend fun getArticleDetail(articleId: String): ArticleDetail

}