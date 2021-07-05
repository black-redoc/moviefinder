package com.josebas.moviefinder.common

import android.content.Context
import android.net.ConnectivityManager
import com.josebas.moviefinder.data.common.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {
    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()) throw NoConnectivityException()
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {
        val connectivityManager = appContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        return connectivityManager.isActiveNetworkMetered
    }
}

class NoConnectivityException: IOException()