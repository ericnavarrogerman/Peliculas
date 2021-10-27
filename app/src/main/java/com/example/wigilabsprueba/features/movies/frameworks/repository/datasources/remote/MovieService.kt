package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote


import com.example.wigilabsprueba.features.movies.entities.PagingEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    companion object{
        const val BASE_URL="https://api.themoviedb.org/"
        const val BASE_URL_IMAGE="https://image.tmdb.org/t/p/original"
        const val GET_POPULAR_MOVIES_PATH="3/movie/popular"
        const val API_KEY="09963e300150f9831c46a1828a82a984"
        const val QUERY_API_KEY="api_key"
        const val QUERY_LANGUAGE="language"
        const val QUERY_PAGINATION="page"
    }

    @GET(GET_POPULAR_MOVIES_PATH)
    suspend fun getAllMovies(
        @Query(QUERY_API_KEY) apiKey:String= API_KEY,
        @Query(QUERY_LANGUAGE)language:String="en-US",
        @Query(QUERY_PAGINATION) page:Int
    ):Response<PagingEntity>



}