package com.salman.mvvmclean.domain.util

import android.content.Context
import android.net.ConnectivityManager

object Utils {

//    @ApplicationContext
//    val app: Application = TODO()

    fun isNetworkAvailable(app: Context): Boolean {
        return (app
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo != null
    }
}