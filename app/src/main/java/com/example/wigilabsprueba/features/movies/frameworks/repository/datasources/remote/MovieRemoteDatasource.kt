package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote

import android.util.Log
import com.example.wigilabsprueba.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieRemoteDatasource{

    private val apiInterface:MovieService by lazy {
        provideRetrofit(MovieService.BASE_URL).create(MovieService::class.java)
    }

    private fun provideRetrofit(url:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor {
                Log.i("API", it)
            }

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)

            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }


    suspend fun getAllPopularMoviesByPageId(page:Int)=apiInterface.getAllMovies(page = page)


}