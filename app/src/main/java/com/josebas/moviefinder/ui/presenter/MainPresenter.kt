package com.josebas.moviefinder.ui.presenter

import androidx.fragment.app.Fragment
import com.josebas.moviefinder.ui.HomeFragment
import com.josebas.moviefinder.ui.MovieFragment
import com.josebas.moviefinder.ui.SearchFragment
import com.josebas.moviefinder.ui.SeriesFragment

class MainPresenter(private val view: View) {

    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var seriesFragment: SeriesFragment
    private lateinit var movieFragment: MovieFragment

    interface View {
        fun replaceFragment(fragment: Fragment)
    }

    fun onCreate(
        searchFragment: SearchFragment,
        seriesFragment: SeriesFragment,
        movieFragment: MovieFragment,
        homeFragment: HomeFragment
    ) {
        this.searchFragment = searchFragment
        this.seriesFragment = seriesFragment
        this.movieFragment = movieFragment
        this.homeFragment = homeFragment

        view.replaceFragment(homeFragment)
    }

    fun onUpdateFragment(): (Int) -> Unit = { item: Int ->
        when(item) {
            0 -> view.replaceFragment(searchFragment)
            1 -> view.replaceFragment(movieFragment)
            2 -> view.replaceFragment(homeFragment)
            3 -> view.replaceFragment(seriesFragment)
            else -> view.replaceFragment(homeFragment)
        }
    }
}