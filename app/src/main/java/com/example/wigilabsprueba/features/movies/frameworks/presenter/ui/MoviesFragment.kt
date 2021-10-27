package com.example.wigilabsprueba.features.movies.frameworks.presenter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.wigilabsprueba.R
import com.example.wigilabsprueba.core.util.notifyErrorWithAction
import com.example.wigilabsprueba.databinding.MoviesFragmentBinding
import com.example.wigilabsprueba.features.movies.frameworks.model.MovieItem
import com.example.wigilabsprueba.features.movies.frameworks.model.Result
import com.example.wigilabsprueba.features.movies.frameworks.presenter.adapters.AdapterMovies
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

        var adapterMovies=AdapterMovies(this)
        val decoration: RecyclerView.ItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvMovies.apply {
            adapter=adapterMovies
            addItemDecoration(decoration)
        }


        model.fecthFromWebService()
        model.getMovies()

        model.result.observe(viewLifecycleOwner, Observer {
            var result=it as Result.Error
            result.exception.message?.let { it1 -> notifyErrorWithAction(it1,"Reload",model::fecthFromWebService) }
        })

        model.movies.observe(viewLifecycleOwner, Observer {
            adapterMovies.setListMovies(it)
        })

    }

    fun gotoDetails(item:MovieItem){
        val accion=MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(item.id)
        findNavController().navigate(accion)
    }


}