package com.example.wigilabsprueba.features.movies.frameworks.model

data class MovieDetails(
    var id:Int,
    var image:String,
    var title:String,
    var description:String,
    var popularity:String,
    var release_date:String,
    var vote_average:Float,
    var vote_count:Int
)