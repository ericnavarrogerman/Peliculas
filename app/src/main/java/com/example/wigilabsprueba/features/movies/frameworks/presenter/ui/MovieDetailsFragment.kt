package com.example.wigilabsprueba.features.movies.frameworks.presenter.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wigilabsprueba.R
import com.example.wigilabsprueba.databinding.MovieDetailsFragmentBinding
import com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {


    private lateinit var viewModel: MovieDetailsViewModel
    lateinit var binding: MovieDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= MovieDetailsFragmentBinding.bind(inflater.inflate(R.layout.movie_details_fragment, container, false))
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}