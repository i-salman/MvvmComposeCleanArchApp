package com.salman.mvvmclean.presentation.article

import com.salman.mvvmclean.domain.model.Article


sealed class ArticleState {
    data class Success (val articles: List<Article>) : ArticleState()
    data class Error(val message: String): ArticleState()
    object Loading: ArticleState()
    object Empty: ArticleState()

}
//data class ArticleState (
//    val isLoading: Boolean = false,
//    val articles: List<Article> = emptyList(),
//    val error: String = ""
//
//)

