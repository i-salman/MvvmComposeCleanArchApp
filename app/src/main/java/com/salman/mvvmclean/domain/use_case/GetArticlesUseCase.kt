package com.salman.mvvmcleanclean.domain.use_case

import com.salman.mvvmcleanclean.common.Response
import com.salman.mvvmcleanclean.domain.model.Article
import com.salman.mvvmcleanclean.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
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