package com.josebas.moviefinder.data.datasource.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.josebas.moviefinder.data.common.API_KEY
import com.josebas.moviefinder.data.common.BASE_URL
import com.josebas.moviefinder.domain.remote.RemoteResultMovie
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RemoteMovieDataSource {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): RemoteResultMovie

    @GET("movie/popular")
    suspend fun getPopularMovies(): RemoteResultMovie

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(): RemoteResultMovie

    companion object {
        operator fun invoke(pathUrl: String = BASE_URL): RemoteMovieDataSource {
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
                .build()

            return Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(pathUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemoteMovieDataSource::class.java)
        }
    }
}