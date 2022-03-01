package com.salman.mvvm.domain.repository

import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail

interface ArticleRepository {

    suspend fun getArticles(): List<Article>

    suspend fun getArticleDetail(articleId: String): Article

}