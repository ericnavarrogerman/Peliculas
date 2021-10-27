package com.example.wigilabsprueba.features.movies.frameworks.model

import com.example.wigilabsprueba.features.movies.entities.MovieEntity


data class ResponseService(
    var page:Int,
    var results:List<MovieEntity>,
    var total_pages:Int,
    var total_results:Int

)
