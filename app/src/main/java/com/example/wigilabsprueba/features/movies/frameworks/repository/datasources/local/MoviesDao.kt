package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local

import androidx.room.*
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom
import com.example.wigilabsprueba.features.movies.frameworks.model.PagingEntityRom
import kotlinx.coroutines.flow.Flow


@Dao
interface MoviesDao {

   @Query("SELECT * FROM Movies WHERE id_service=:id")
    fun findMovieById(id:Int): Flow<MoviesEntityRom>

   @Query("SELECT * FROM Movies ORDER BY id_service")
    fun findAllMovies():Flow<List<MoviesEntityRom>>

   @Delete
   suspend fun deleteMovies(users: MoviesEntityRom)

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun InsertAllMovies( users: List<MoviesEntityRom>):List<Long>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun InsertPaging(pagingEntityRom: PagingEntityRom):Long

   @Query("SELECT * FROM Paging WHERE id=:id")
   fun findPagingById(id: Int):PagingEntityRom

}