package com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wigilabsprueba.features.movies.frameworks.model.MovieDetails
import com.example.wigilabsprueba.features.movies.frameworks.model.Result
import com.example.wigilabsprueba.features.movies.interactors.GetMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor( private var getDetails:GetMovieDetails): ViewModel() {


    private val _result: MutableLiveData<MovieDetails> = MutableLiveData()
    val result: LiveData<MovieDetails> = _result




    fun getMovieDetailsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            var result=getDetails.getMovieDetailsById(id)

            result.catch { cause: Throwable -> MovieDetails(
                0,
                "https://cdn.pixabay.com/photo/2016/04/24/22/30/monitor-1350918_960_720.png",
                "ERROR",
                "An unexpected error has occurred, it seems that the selected item is no longer in the database, please contact support.",
                "0",
                "",
                0f,
                0
            )}
                .collect {

                    _result.postValue(
                        MovieDetails(
                            it.id,
                            it.backdrop_path,
                            it.original_title,
                            it.overview,
                            it.popularity,
                            it.release_date,
                            it.vote_average,
                            it.vote_count

                        )
                    )

                }

        }
    }



}