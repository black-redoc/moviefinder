package com.josebas.moviefinder.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josebas.moviefinder.databinding.FragmentHomeBinding
import com.josebas.moviefinder.ui.commons.MovieType
import com.josebas.moviefinder.ui.commons.TVShowType
import com.josebas.moviefinder.ui.presenter.HomePresenter
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HomeFragment(private val homePresenter: HomePresenter) : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        renderViewPager()
        return binding.root
    }

    private fun renderViewPager() {
        with(binding) {
            homePresenter.renderViewPager(viewPagerContainer, MovieType())
            homePresenter.renderViewPager(viewPagerDramaContainer, MovieType())
            homePresenter.renderViewPager(viewPagerActionContainer, MovieType())
            homePresenter.renderViewPager(viewPagerTVShowContainer, TVShowType())
        }
    }
}