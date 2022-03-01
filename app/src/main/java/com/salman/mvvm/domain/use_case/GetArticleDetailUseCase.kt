package com.salman.mvvm.domain.use_case

import android.util.Log
import com.salman.mvvm.common.Response
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.domain.model.ArticleDetail
import com.salman.mvvm.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticleDetailUseCase @Inject constructor(
    private val repository: ArticleRepository
) {

    operator fun invoke(articleId: String): Flow<Response<ArticleDetail>> = flow {
        try {
            emit(Response.Loading<ArticleDetail>())
            val article = repository.getArticleDetail(articleId)
            emit(Response.Success<ArticleDetail>(article))
        } catch (e: HttpException) {
            emit(Response.Error<ArticleDetail>(e.localizedMessage))
        } catch (e: IOException) {
            emit(Response.Error<ArticleDetail>("Could not reach server, Check internet connection"))
        }
    }

}