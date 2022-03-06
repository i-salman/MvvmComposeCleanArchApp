package com.salman.mvvmclean.presentation.article

import com.salman.mvvmclean.domain.model.Article

data class ArticleState (
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""

)

