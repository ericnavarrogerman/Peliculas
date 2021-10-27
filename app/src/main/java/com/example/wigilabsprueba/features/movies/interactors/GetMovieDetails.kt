package com.example.wigilabsprueba.features.movies.interactors


import com.example.wigilabsprueba.features.movies.frameworks.repository.Repository
import javax.inject.Inject

class GetMovieDetails @Inject constructor( private var repository: Repository){

    fun getMovieDetailsById(id:Int)=repository.getMovieById(id)
}