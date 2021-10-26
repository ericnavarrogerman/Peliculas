package com.example.wigilabsprueba.features.movies.frameworks.presenter.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.wigilabsprueba.R
import com.example.wigilabsprueba.databinding.MoviesFragmentBinding
import com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {


    val model:MoviesViewModel by viewModels()
    lateinit var binding: MoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=MoviesFragmentBinding.bind(inflater.inflate(R.layout.movies_fragment, container, false))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        model.getMovies()

    }


}