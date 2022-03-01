package com.salman.mvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salman.mvvm.domain.model.Article


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