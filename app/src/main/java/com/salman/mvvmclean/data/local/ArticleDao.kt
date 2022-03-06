package com.salman.mvvmclean.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salman.mvvmclean.domain.model.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    suspend fun getArticles(): List<Article>

    @Query("SELECT * FROM article WHERE id=:id")
    suspend fun getArticleDetail(id: String): Article

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<Article>)

}