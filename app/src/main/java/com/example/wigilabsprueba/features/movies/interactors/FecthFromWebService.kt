package com.example.wigilabsprueba.features.movies.interactors

import com.example.wigilabsprueba.features.movies.frameworks.repository.Repository
import javax.inject.Inject

class FecthFromWebService @Inject constructor(private var repo:Repository):Interactor(){

    suspend fun fecthFromWebService()=repo.fetchMoreData()

}