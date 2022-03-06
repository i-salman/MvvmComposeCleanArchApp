package com.salman.mvvmclean.domain.repository

import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.model.ArticleDetail

interface ArticleRepository {

    suspend fun getArticles(): List<Article>

    suspend fun getArticleDetail(articleId: String): Article

}