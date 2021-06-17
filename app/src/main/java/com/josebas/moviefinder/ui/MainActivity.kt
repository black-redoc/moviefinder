package com.josebas.moviefinder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.josebas.moviefinder.R
import com.josebas.moviefinder.databinding.ActivityMainBinding
import com.josebas.moviefinder.ui.presenter.MainPresenter

class MainActivity : AppCompatActivity() {
    private val mainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityMainBinding.inflate(layoutInflater)) {
            mainPresenter.initFragment(supportFragmentManager, R.id.fragment_container)
            setContentView(root)
            bottomBar.onItemSelected = mainPresenter.onUpdateFragment()
        }
    }
}