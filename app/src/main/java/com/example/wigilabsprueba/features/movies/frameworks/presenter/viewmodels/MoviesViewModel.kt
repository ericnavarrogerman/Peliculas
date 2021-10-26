package com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wigilabsprueba.features.movies.frameworks.model.MovieEntityApi
import com.example.wigilabsprueba.features.movies.interactors.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private var getMovies:GetMovies): ViewModel() {

    private val _movies: MutableLiveData<List<MovieEntityApi>> = MutableLiveData()
    val movies: LiveData<List<MovieEntityApi>> = _movies



    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->

            throwable.toString()
    }

    fun getMovies(){


    viewModelScope.launch (Dispatchers.IO + exceptionHandler){

      var resultado = getMovies.getMovies()
        resultado.isSuccessful

        resultado.toString()



    }


    }

}