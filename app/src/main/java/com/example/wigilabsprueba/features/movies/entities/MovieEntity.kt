package com.example.wigilabsprueba.features.movies.entities

import androidx.room.Entity


data class MovieEntity(
    var adult:Boolean,
    var backdrop_path:String,
    var genre_ids:List<Int>,
    var id:Int,
    var original_language:String,
    var original_title:String,
    var overview:String,
    var popularity:String,
    var poster_path:String,
    var release_date:String,
    var title:String,
    var video:String,
    var vote_average:Float,
    var vote_count:Int

)
