package com.salman.mvvmclean.domain.util

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

object Utils {

//    @ApplicationContext
//    val app: Application = TODO()

    fun isNetworkAvailable(app: Context): Boolean {
        return (app
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo != null
    }
}