package com.example.wigilabsprueba.features.movies.frameworks.repository

import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local.MovieLocalDatasource
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote.MovieRemoteDatasource

class Repository(
    var remoteDatasource: MovieRemoteDatasource,
    var localDatasource: MovieLocalDatasource
){

    suspend fun getMoviesRemote()=remoteDatasource.getAllPopularMoviesByPageId("50")


}