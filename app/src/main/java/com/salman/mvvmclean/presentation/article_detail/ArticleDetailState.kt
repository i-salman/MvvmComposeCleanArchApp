package com.salman.mvvmclean.presentation.article_detail

import com.salman.mvvmclean.domain.model.ArticleDetail

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: ArticleDetail? = null,
    val error: String = ""
)