package com.example.wigilabsprueba.features.movies.frameworks.repository

import com.example.wigilabsprueba.core.exceptions.DataEmpity
import com.example.wigilabsprueba.core.exceptions.ServerError
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom
import com.example.wigilabsprueba.features.movies.frameworks.model.Result
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local.MovieLocalDatasource
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote.MovieRemoteDatasource
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote.MovieService.Companion.BASE_URL_IMAGE

class Repository(
    var remoteDatasource: MovieRemoteDatasource,
    var localDatasource: MovieLocalDatasource
) {


    suspend fun fetchMoreData(): Result<Any> {
        try {
            var res = remoteDatasource.getAllPopularMoviesByPageId("51")

            if (res.isSuccessful) {
                res.body()?.let {
                  localDatasource.InsertAllMovies(
                        it.results.map { movieEntityApi ->
                            MoviesEntityRom(
                                movieEntityApi.id,
                                "https://image.tmdb.org/t/p/original${movieEntityApi.backdrop_path}",
                                movieEntityApi.original_title,
                                movieEntityApi.overview,
                                movieEntityApi.popularity,
                                "https://image.tmdb.org/t/p/original${movieEntityApi.poster_path}",
                                movieEntityApi.release_date,
                                movieEntityApi.vote_average
                            )
                        })
                    return Result.Success("Succesfull")
                }
                    throw DataEmpity("The server did not deliver useful data")
            } else {
                res.errorBody()?.let {
                    throw ServerError(it.string())
                }
                throw DataEmpity("The server did not deliver useful data")
            }

        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

    fun getMoviesLocal() = localDatasource.findAllMovies()
}