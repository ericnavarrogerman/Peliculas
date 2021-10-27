package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local

import android.content.Context
import androidx.room.Room
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom
import com.example.wigilabsprueba.features.movies.frameworks.model.PagingEntityRom
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject


class MovieLocalDatasource @Inject constructor(applicationContext: Context) {

    private val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-movies"
    ).build()


    fun findMovieById(id:Int)=db.moviesDao().findMovieById(id).distinctUntilChanged()

    fun findAllMovies()=db.moviesDao().findAllMovies().distinctUntilChanged()

    suspend fun deleteMovies(movies:MoviesEntityRom)=db.moviesDao().deleteMovies(movies)

    suspend fun insertAllMovies(movies:List<MoviesEntityRom>)=db.moviesDao().InsertAllMovies(movies)

    suspend fun insertPaging(pagingEntityRom: PagingEntityRom)=db.moviesDao().InsertPaging(pagingEntityRom)

    fun findPaggin(id: Int)=db.moviesDao().findPagingById(id)
}