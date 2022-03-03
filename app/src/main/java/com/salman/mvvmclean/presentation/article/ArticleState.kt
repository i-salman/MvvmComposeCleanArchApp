package com.salman.mvvmcleanclean.presentation.article

import com.salman.mvvmcleanclean.domain.model.Article

data class ArticleState (
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""

)

