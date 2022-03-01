package com.salman.mvvm.common

import android.content.Context
import com.salman.mvvm.domain.repository.ArticleRepository
import com.salman.mvvm.domain.util.Utils

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