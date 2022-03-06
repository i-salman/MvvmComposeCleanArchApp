package com.salman.mvvmclean.presentation.article_detail

import com.salman.mvvmclean.domain.model.Article

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: Article? = null,
    val error: String = ""
)