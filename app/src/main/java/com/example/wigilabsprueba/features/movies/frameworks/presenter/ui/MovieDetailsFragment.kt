package com.example.wigilabsprueba.features.movies.frameworks.presenter.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.wigilabsprueba.R
import com.example.wigilabsprueba.databinding.MovieDetailsFragmentBinding
import com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels.MovieDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {


    val viewModel: MovieDetailsViewModel by viewModels()
    val args:MovieDetailsFragmentArgs by navArgs()
    lateinit var binding: MovieDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= MovieDetailsFragmentBinding.bind(inflater.inflate(R.layout.movie_details_fragment, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovieDetailsById(args.idMovie)
        viewModel.result.observe(viewLifecycleOwner, Observer {
            binding.details=it
        })
    }


}