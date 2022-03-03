package com.salman.mvvmclean.data.local

import androidx.room.Dao
import androidx.room.Query
import com.salman.mvvmclean.domain.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>
}