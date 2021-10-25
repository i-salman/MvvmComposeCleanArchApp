package com.nxb.mvvm.ui.screens

sealed class Screen(val route: String) {
    object ArticleScreen: Screen("articles")
    object ArticleDetailScreen: Screen("article_detail")
}
