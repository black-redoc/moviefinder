package com.josebas.moviefinder.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josebas.moviefinder.databinding.FragmentHomeBinding
import com.josebas.moviefinder.ui.presenter.HomePresenter
import com.josebas.moviefinder.ui.viewmodel.MotionPictureDetailViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HomeFragment : Fragment(), KodeinAware {
    override val kodein by closestKodein()
    private val movieDetailViewModel by instance<MotionPictureDetailViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainPresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        mainPresenter = HomePresenter(movieDetailViewModel)
        with(binding) {
            mainPresenter.renderViewPager(viewPagerContainer)
            mainPresenter.renderViewPager(viewPagerDramaContainer)
            mainPresenter.renderViewPager(viewPagerActionContainer)
        }

        return binding.root
    }

}