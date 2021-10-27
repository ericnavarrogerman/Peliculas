package com.example.wigilabsprueba.features.movies.frameworks.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Movies")
data class MoviesEntityRom(
    @PrimaryKey(autoGenerate = true) var id:Int=0,
    @ColumnInfo(name = "id_service") var id_service: Int,
    @ColumnInfo(name = "backdrop_image") var backdrop_path: String,
    @ColumnInfo(name = "title") var original_title: String,
    @ColumnInfo(name = "description") var overview: String,
    @ColumnInfo(name = "popularity")var popularity: String,
    @ColumnInfo(name = "poster_image")var poster_path: String,
    @ColumnInfo(name = "release_date")var release_date: String,
    @ColumnInfo(name = "score")var vote_average: Float,
    @ColumnInfo(name = "vote_count") var vote_count:Int
)
