package com.nxb.mvvm.presentation.article

import com.nxb.mvvm.domain.model.Article

data class ArticleState (
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""

)

