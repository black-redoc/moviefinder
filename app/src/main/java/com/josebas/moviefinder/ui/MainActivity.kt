package com.josebas.moviefinder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.josebas.moviefinder.R
import com.josebas.moviefinder.databinding.ActivityMainBinding
import com.josebas.moviefinder.ui.fragments.HomeFragment
import com.josebas.moviefinder.ui.fragments.MovieFragment
import com.josebas.moviefinder.ui.fragments.SearchFragment
import com.josebas.moviefinder.ui.fragments.SeriesFragment
import com.josebas.moviefinder.ui.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainPresenter.View {

    override val homeFragment = HomeFragment()
    override val searchFragment = SearchFragment()
    override val seriesFragment = SeriesFragment()
    override val movieFragment = MovieFragment()
    private lateinit var mainPresenter: MainPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        mainPresenter = MainPresenter(this)

        with(binding) {
            mainPresenter.onCreate()
            bottomBar.onItemSelected = mainPresenter.onUpdateFragment()

            setContentView(root)
        }
    }

    override fun replaceFragment(fragment: Fragment) {
        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}