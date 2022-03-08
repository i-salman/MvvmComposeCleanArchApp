package com.salman.mvvmclean.domain.use_case

import android.util.Log
import com.salman.mvvmclean.common.Response
import com.salman.mvvmclean.data.repository.ArticleRepositoryImpl
import com.salman.mvvmclean.domain.model.Article
import com.salman.mvvmclean.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
) {

    fun getData() = flow {
        try {
            emit(Response.Loading())
            val articles = repository.getArticles()
            emit(Response.Success(articles))
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage))
        } catch (e: IOException) {
            emit(Response.Error("Could not reach server, Check internet connection"))
        }
    }
}