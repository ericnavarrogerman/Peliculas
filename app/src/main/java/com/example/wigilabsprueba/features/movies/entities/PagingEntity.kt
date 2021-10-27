package com.example.wigilabsprueba.features.movies.entities

import com.example.wigilabsprueba.features.movies.entities.MovieEntity


data class PagingEntity(
    var page:Int,
    var results:List<MovieEntity>,
    var total_pages:Int,
    var total_results:Int

)
