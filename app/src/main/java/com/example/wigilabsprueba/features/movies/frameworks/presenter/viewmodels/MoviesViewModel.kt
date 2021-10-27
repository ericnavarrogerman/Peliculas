package com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wigilabsprueba.core.util.cut
import com.example.wigilabsprueba.features.movies.entities.MovieEntity
import com.example.wigilabsprueba.features.movies.frameworks.model.MovieItem
import com.example.wigilabsprueba.features.movies.frameworks.model.Result
import com.example.wigilabsprueba.features.movies.interactors.FecthFromWebService
import com.example.wigilabsprueba.features.movies.interactors.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private var getMovies:GetMovies,
    private var fecthFromWebService: FecthFromWebService
    ): ViewModel() {


    private val _result: MutableLiveData<Result<Any>> = MutableLiveData()
    val result: LiveData<Result<Any>> = _result


    private val _movies: MutableLiveData<ArrayList<MovieItem>> = MutableLiveData()
    val movies: LiveData<ArrayList<MovieItem>> = _movies


    fun fecthFromWebService(){
        viewModelScope.launch (Dispatchers.IO){
         var result =fecthFromWebService.fecthFromWebService()
           if (result is Result.Error){
                _result.postValue(result)
           }
        }
    }

    fun getMovies(){

    viewModelScope.launch (Dispatchers.IO){

      var resultado = getMovies.getMovies()


      resultado.catch { cause: Throwable -> _result.postValue(Result.Error(Exception(cause)))}
          .collect { movies->

              _movies.postValue(movies.map { moviesEntityRom ->

                  MovieItem(
                      moviesEntityRom.id,
                      moviesEntityRom.poster_path,
                      moviesEntityRom.original_title,
                      moviesEntityRom.overview.cut(90)
                  ) } as ArrayList<MovieItem>?)
          }

    }


    }

}