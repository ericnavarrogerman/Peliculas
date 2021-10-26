package com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels

import androidx.lifecycle.ViewModel
import com.example.wigilabsprueba.features.movies.interactors.GetMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(var getDetails:GetMovieDetails): ViewModel() {

}