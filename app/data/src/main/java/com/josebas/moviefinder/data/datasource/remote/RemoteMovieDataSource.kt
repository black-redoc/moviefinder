package com.josebas.moviefinder.data.datasource.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.josebas.moviefinder.data.common.ConnectivityInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import com.josebas.moviefinder.domain.remote.RemoteResult
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET

const val BASE_URL = "https://api.themoviedb.org/3"
const val API_KEY = "5dbc08164db12809ab28eb9709577f91"

interface RemoteMovieDataSource {
    @GET("/movie/top_rated")
    fun getTopRatedMovies(): List<RemoteResult>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): RemoteMovieDataSource {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemoteMovieDataSource::class.java)
        }
    }
}