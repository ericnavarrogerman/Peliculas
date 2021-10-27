package com.example.wigilabsprueba.features.movies.frameworks.repository

import com.example.wigilabsprueba.core.exceptions.PaginationFinished
import com.example.wigilabsprueba.core.exceptions.ServerError
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom
import com.example.wigilabsprueba.features.movies.frameworks.model.PagingEntityRom
import com.example.wigilabsprueba.features.movies.frameworks.model.Result
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local.MovieLocalDatasource
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote.MovieRemoteDatasource

class Repository(
    var remoteDatasource: MovieRemoteDatasource,
    var localDatasource: MovieLocalDatasource
) {

    suspend fun fetchMoreData(): Result<Any> {
        try {


            var paging=localDatasource.findPaggin(1)

            var page=if (paging==null) 1 else paging.page+1
            if (page>paging.total_pages){ throw PaginationFinished("There is no more data to show at the moment")}

            var res = remoteDatasource.getAllPopularMoviesByPageId(page)

            if (res.isSuccessful) {
                res.body()?.let {


                  localDatasource.insertPaging(
                      PagingEntityRom(
                          1,
                          it.page,
                          it.total_pages,
                          it.total_results,

                      )
                  )
                  localDatasource.insertAllMovies(
                        it.results.map { movieEntityApi ->
                            MoviesEntityRom(
                                0,
                                movieEntityApi.id,
                                "https://image.tmdb.org/t/p/original${movieEntityApi.backdrop_path}",
                                movieEntityApi.original_title,
                                movieEntityApi.overview,
                                movieEntityApi.popularity,
                                "https://image.tmdb.org/t/p/original${movieEntityApi.poster_path}",
                                movieEntityApi.release_date,
                                movieEntityApi.vote_average,
                                movieEntityApi.vote_count
                            )
                        })
                    return Result.Success("Succesfull")
                }
                    throw PaginationFinished("The server did not deliver useful data")
            } else {
                res.errorBody()?.let {
                    throw ServerError(it.string())
                }
                throw PaginationFinished("The server did not deliver useful data")
            }

        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

    fun getMoviesLocal() = localDatasource.findAllMovies()

    fun getMovieById(id:Int)=localDatasource.findMovieById(id)
}