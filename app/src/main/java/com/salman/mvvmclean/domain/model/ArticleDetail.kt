package com.salman.mvvmclean.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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