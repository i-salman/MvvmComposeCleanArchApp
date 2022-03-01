package com.salman.mvvm.presentation.article

import com.salman.mvvm.domain.model.Article

data class ArticleState (
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""

)

