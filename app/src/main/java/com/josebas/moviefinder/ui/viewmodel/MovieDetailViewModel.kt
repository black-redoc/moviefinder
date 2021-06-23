package com.josebas.moviefinder.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josebas.moviefinder.domain.Movie

class MovieDetailViewModel: ViewModel() {
    private val movieLiveData = MutableLiveData<Movie>()

    val movieData: LiveData<Movie>
        get() = movieLiveData

    fun setMovie(movie: Movie) {
        movieLiveData.value = movie
    }
}