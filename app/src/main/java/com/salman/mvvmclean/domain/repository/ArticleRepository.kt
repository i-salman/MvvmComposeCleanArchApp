package com.salman.mvvmclean.domain.repository

import com.salman.mvvmclean.domain.model.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}