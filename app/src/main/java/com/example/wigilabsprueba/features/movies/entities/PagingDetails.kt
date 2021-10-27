package com.example.wigilabsprueba.features.movies.entities

data class PagingDetails(
    val page:Int,
    var total_pages:Int,
    var total_results:Int,
    var errors:String
)
