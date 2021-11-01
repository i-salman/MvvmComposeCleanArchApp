package com.nxb.mvvm.di

import android.app.Application
import androidx.room.Room
import com.nxb.mvvm.common.ArticleDataFactory
import com.nxb.mvvm.common.Constants
import com.nxb.mvvm.data.local.AppDatabase
import com.nxb.mvvm.data.remote.RemoteApi
import com.nxb.mvvm.data.repository.ArticleDataRepository
import com.nxb.mvvm.data.repository.ArticleLocalRepositoryImpl
import com.nxb.mvvm.data.repository.ArticleRemoteRepositoryImpl
import com.nxb.mvvm.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
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
    @Named("remote")
    fun provideArticleRepository(api: RemoteApi, db: AppDatabase): ArticleRepository {
        return ArticleRemoteRepositoryImpl(api, db.articleDao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build();
    }

    @Provides
    @Singleton
    @Named("local")
    fun provideArticleLocalRepository(db: AppDatabase): ArticleRepository {
        return ArticleLocalRepositoryImpl(db.articleDao)
    }

    @Provides
    @Singleton
    fun provideArticleDataFactory(app: Application,
                                  @Named("local") local : ArticleRepository,
                                  @Named("remote") remote: ArticleRepository
    ): ArticleDataFactory {
        return ArticleDataFactory(app, local, remote)
    }

    @Provides
    @Singleton
    fun provideArticleDataRepository(factory: ArticleDataFactory): ArticleDataRepository {
        return ArticleDataRepository(factory)
    }

}