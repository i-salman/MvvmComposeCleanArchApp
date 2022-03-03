package com.salman.mvvmclean.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salman.mvvmclean.domain.model.Article


@Database(
    entities = [Article::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val articleDao: ArticleDao

    companion object {
        const val DATABASE_NAME = "AppDatabase_db"
    }
}