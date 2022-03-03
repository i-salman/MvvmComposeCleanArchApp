package com.salman.mvvmcleanclean.domain.repository

import com.salman.mvvmcleanclean.domain.model.Article
import com.salman.mvvmcleanclean.domain.model.ArticleDetail

interface ArticleRepository {

    suspend fun getArticles(): List<Article>

    suspend fun getArticleDetail(articleId: String): ArticleDetail

}