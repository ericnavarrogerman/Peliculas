package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local

import androidx.room.*
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDao {

   @Query("SELECT * FROM Movies WHERE id=:id")
   suspend fun findMovieById(id:Int): Flow<MoviesEntityRom>

   @Query("SELECT * FROM movies")
   suspend fun findAllMovies():Flow<List<MoviesEntityRom>>

   @Delete
   suspend fun deleteMovies(users: MoviesEntityRom):List<Long>

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun InsertAllMovies( users: List<MoviesEntityRom>):List<Long>

}