package com.salman.mvvmclean.di

import android.app.Application
import androidx.room.Room
import com.salman.mvvmclean.common.Constants
import com.salman.mvvmclean.data.local.AppDatabase
import com.salman.mvvmclean.data.remote.RemoteApi
import com.salman.mvvmclean.data.repository.ArticleRepositoryImpl
import com.salman.mvvmclean.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRemoteApi(): RemoteApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideArticleRepository(api: RemoteApi): ArticleRepository {
        return ArticleRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build();
    }
}