package com.salman.mvvmclean.presentation.article_detail

import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.model.ArticleDetail

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: Article? = null,
    val error: String = ""
)