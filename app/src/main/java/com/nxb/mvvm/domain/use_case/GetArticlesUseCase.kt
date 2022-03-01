package com.salman.mvvm.domain.use_case

import com.salman.mvvm.common.Response
import com.salman.mvvm.data.repository.ArticleDataRepository
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleDataRepository
) {

    operator fun invoke(): Flow<Response<List<Article>>> = flow {
        try {
            emit(Response.Loading<List<Article>>())
            val articles = repository.getArticles()
            emit(Response.Success(articles))
        } catch (e: HttpException) {
            emit(Response.Error<List<Article>>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Response.Error<List<Article>>("Could not reach server, Check internet connection"))
        }
    }
}