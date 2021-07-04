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

class HomeFragment : Fragment(), KodeinAware {
    override val kodein by closestKodein()
    private val homePresenter: HomePresenter by instance()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainPresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
//        mainPresenter = HomePresenter(motionPictureDetailViewModel, movieRepository)
        mainPresenter = homePresenter
        renderViewPager()

        return binding.root
    }

    private fun renderViewPager() {
        with(binding) {
            mainPresenter.renderViewPager(viewPagerContainer, MovieType())
            mainPresenter.renderViewPager(viewPagerDramaContainer, MovieType())
            mainPresenter.renderViewPager(viewPagerActionContainer, MovieType())
            mainPresenter.renderViewPager(viewPagerTVShowContainer, TVShowType())
        }
    }
}