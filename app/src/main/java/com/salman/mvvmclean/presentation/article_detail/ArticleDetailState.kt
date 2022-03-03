package com.salman.mvvmcleanclean.presentation.article_detail

import com.salman.mvvmcleanclean.domain.model.ArticleDetail

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: ArticleDetail? = null,
    val error: String = ""
)