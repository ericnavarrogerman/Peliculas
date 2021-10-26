package com.example.wigilabsprueba.features.movies.frameworks.presenter.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wigilabsprueba.R
import com.example.wigilabsprueba.databinding.MoviesFragmentBinding
import com.example.wigilabsprueba.features.movies.frameworks.presenter.viewmodels.MoviesViewModel

class MoviesFragment : Fragment() {


    private lateinit var viewModel: MoviesViewModel
    lateinit var binding: MoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=MoviesFragmentBinding.bind(inflater.inflate(R.layout.movies_fragment, container, false))

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

    }

}