package com.nxb.mvvm.data.local

import androidx.room.Dao
import androidx.room.Query
import com.nxb.mvvm.domain.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>
}