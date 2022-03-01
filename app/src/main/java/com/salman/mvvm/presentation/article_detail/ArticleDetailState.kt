package com.salman.mvvm.presentation.article_detail

import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: ArticleDetail? = null,
    val error: String = ""
)