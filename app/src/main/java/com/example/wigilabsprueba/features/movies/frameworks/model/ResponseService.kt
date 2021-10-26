package com.example.wigilabsprueba.features.movies.frameworks.model


data class ResponseService(
    var page:Int,
    var results:List<MovieEntityApi>,
    var total_pages:Int,
    var total_results:Int,
    var errors:List<String>
)
