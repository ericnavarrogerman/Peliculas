package com.example.wigilabsprueba.features.movies.interactors


import com.example.wigilabsprueba.features.movies.frameworks.repository.Repository
import javax.inject.Inject

class GetMovies @Inject constructor(private var repository: Repository):Interactor(){
    fun getMovies()=repository.getMoviesLocal()
}