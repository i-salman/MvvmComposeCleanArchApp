package com.salman.mvvm.domain.use_case

import android.util.Log
import com.salman.mvvm.common.Response
import com.salman.mvvm.data.repository.ArticleDataRepository
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail
import com.salman.mvvm.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

class GetArticleDetailUseCase @Inject constructor(
    private val repository: ArticleDataRepository
) {

    operator fun invoke(articleId: String): Flow<Response<Article>> = flow {
        try {
            emit(Response.Loading<Article>())
            val article = repository.getArticleDetail(articleId)
            emit(Response.Success<Article>(article))
        } catch (e: HttpException) {
            emit(Response.Error<Article>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Response.Error<Article>("Could not reach server, Check internet connection"))
        }
    }

}