package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom

@Database(
     entities = [MoviesEntityRom::class],
     version = 1
 )
abstract class AppDatabase: RoomDatabase(){
    abstract fun moviesDao():MoviesDao
}
