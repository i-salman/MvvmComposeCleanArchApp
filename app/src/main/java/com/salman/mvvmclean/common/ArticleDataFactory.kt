package com.salman.mvvmclean.common

import android.content.Context
import com.salman.mvvmclean.domain.repository.ArticleRepository
import com.salman.mvvmclean.domain.util.Utils

class ArticleDataFactory (
    val app: Context,
    private val localRepository: ArticleRepository,
    private val remoteRepository: ArticleRepository
) {

    fun getRepository(): ArticleRepository {
        if(!Utils.isNetworkAvailable(app)) {
            return localRepository
        } else {
            return remoteRepository
        }
    }
}