package com.josebas.moviefinder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.josebas.moviefinder.R
import com.josebas.moviefinder.databinding.ActivityMainBinding
import com.josebas.moviefinder.ui.fragments.HomeFragment
import com.josebas.moviefinder.ui.fragments.MovieFragment
import com.josebas.moviefinder.ui.fragments.SearchFragment
import com.josebas.moviefinder.ui.fragments.SeriesFragment
import com.josebas.moviefinder.ui.presenter.MainPresenter
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.on

class MainActivity : AppCompatActivity(), MainPresenter.View, KodeinAware {
    override val kodein by closestKodein()

    override val homeFragment: HomeFragment by instance()
    override val searchFragment = SearchFragment()
    override val seriesFragment = SeriesFragment()
    override val movieFragment = MovieFragment()
    private val mainPresenter: MainPresenter by instance(arg = this)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

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