package com.example.wigilabsprueba.features.movies.frameworks.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wigilabsprueba.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Movies)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}