package com.salman.mvvmcleanclean.di

import android.app.Application
import androidx.room.Room
import com.salman.mvvmcleanclean.common.Constants
import com.salman.mvvmcleanclean.data.local.AppDatabase
import com.salman.mvvmcleanclean.data.remote.RemoteApi
import com.salman.mvvmcleanclean.data.repository.ArticleRepositoryImpl
import com.salman.mvvmcleanclean.domain.repository.ArticleRepository
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