package com.josebas.moviefinder.ui.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.josebas.moviefinder.ui.HomeFragment
import com.josebas.moviefinder.ui.MovieFragment
import com.josebas.moviefinder.ui.SearchFragment
import com.josebas.moviefinder.ui.SeriesFragment
import me.ibrahimsn.lib.SmoothBottomBar

class MainPresenter {

    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val seriesFragment = SeriesFragment()
    private val movieFragment = MovieFragment()
    private lateinit var supportFragmentManager: FragmentManager
    private var fragmentContainer: Int? = null

    fun initFragment(supportFragmentManager: FragmentManager, fragmentContainer: Int) {
        this.fragmentContainer = fragmentContainer
        this.supportFragmentManager = supportFragmentManager
        replaceFragment(homeFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        with(supportFragmentManager.beginTransaction()) {
            replace(fragmentContainer!!, fragment)
            commit()
        }
    }

    fun onUpdateFragment(): ((Int) -> Unit) = { it: Int ->
        when(it) {
            0 -> replaceFragment(searchFragment)
            1 -> replaceFragment(movieFragment)
            2 -> replaceFragment(homeFragment)
            3 -> replaceFragment(seriesFragment)
            else -> replaceFragment(homeFragment)
        }
    }
}