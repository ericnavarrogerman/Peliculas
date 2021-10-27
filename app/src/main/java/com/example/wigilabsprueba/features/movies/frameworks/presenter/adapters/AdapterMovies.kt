package com.example.wigilabsprueba.features.movies.frameworks.presenter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wigilabsprueba.R
import com.example.wigilabsprueba.databinding.ItemListBinding
import com.example.wigilabsprueba.features.movies.frameworks.model.MovieItem
import com.example.wigilabsprueba.features.movies.frameworks.presenter.ui.MoviesFragment

class AdapterMovies(var fragment: MoviesFragment) :RecyclerView.Adapter<AdapterMovies.ViewHolder>() {


    var list = ArrayList<MovieItem>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding= ItemListBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMovies.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterMovies.ViewHolder, position: Int) {

        holder.binding.movie=list.get(position)
        holder.binding.fragment=fragment

    }

    override fun getItemCount()=list.size



    fun setListMovies(list: ArrayList<MovieItem>){
        this.list=list
        notifyDataSetChanged()
    }
}