package com.salman.mvvmcleanclean.domain.model

data class ArticleDetail(
    val id: Int,
    val imageUrl: String,
    val newsSite: String,
    val publishedAt: String,
    val summary: String,
    val title: String,
    val updatedAt: String,
    val url: String
)