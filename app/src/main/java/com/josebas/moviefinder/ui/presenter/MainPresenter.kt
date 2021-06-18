package com.josebas.moviefinder.ui.presenter

import androidx.fragment.app.Fragment
import com.josebas.moviefinder.ui.HomeFragment
import com.josebas.moviefinder.ui.MovieFragment
import com.josebas.moviefinder.ui.SearchFragment
import com.josebas.moviefinder.ui.SeriesFragment

class MainPresenter(private var view: View) {

    interface View {
        val homeFragment: HomeFragment
        val searchFragment: SearchFragment
        val seriesFragment: SeriesFragment
        val movieFragment: MovieFragment

        fun replaceFragment(fragment: Fragment)
    }

    fun onCreate(

    ) {
        view.replaceFragment(view.homeFragment)
    }

    fun onUpdateFragment(): (Int) -> Unit = { item: Int ->
        when(item) {
            0 -> view.replaceFragment(view.searchFragment)
            1 -> view.replaceFragment(view.movieFragment)
            2 -> view.replaceFragment(view.homeFragment)
            3 -> view.replaceFragment(view.seriesFragment)
            else -> view.replaceFragment(view.homeFragment)
        }
    }
}