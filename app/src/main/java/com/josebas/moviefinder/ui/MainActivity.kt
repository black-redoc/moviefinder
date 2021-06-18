package com.josebas.moviefinder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.josebas.moviefinder.R
import com.josebas.moviefinder.databinding.ActivityMainBinding
import com.josebas.moviefinder.ui.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainPresenter.View{
    private val mainPresenter = MainPresenter(this)
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val seriesFragment = SeriesFragment()
    private val movieFragment = MovieFragment()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding) {
            mainPresenter.onCreate(searchFragment, seriesFragment, movieFragment, homeFragment)
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