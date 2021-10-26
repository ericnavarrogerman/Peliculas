package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local

import android.content.Context
import androidx.room.Room
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom


class MovieLocalDatasource(applicationContext: Context) {

    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-movies"
    ).build()

    suspend fun findMovieById(id:Int)=db.moviesDao().findMovieById(id)

    suspend fun findAllMovies()=db.moviesDao().findAllMovies()

    suspend fun deleteMovies(movies:MoviesEntityRom)=db.moviesDao().deleteMovies(movies)

    suspend fun InsertAllMovies(movies:List<MoviesEntityRom>)=db.moviesDao().InsertAllMovies(movies)

}