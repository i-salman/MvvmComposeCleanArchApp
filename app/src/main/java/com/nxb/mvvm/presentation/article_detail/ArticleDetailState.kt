package com.nxb.mvvm.presentation.article_detail

import com.nxb.mvvm.domain.model.Article
import com.nxb.mvvm.domain.model.ArticleDetail

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: ArticleDetail? = null,
    val error: String = ""
)