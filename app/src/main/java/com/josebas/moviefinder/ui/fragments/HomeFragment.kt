package com.josebas.moviefinder.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.josebas.moviefinder.databinding.FragmentHomeBinding
import com.josebas.moviefinder.domain.datasource.InMemoryMovieDataSource
import com.josebas.moviefinder.ui.presenter.HomePresenter
import com.josebas.moviefinder.ui.recycler.SliderAdapter
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val mainPresenter = HomePresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        with(binding) {
            mainPresenter.renderViewPager(viewPagerContainer)
            mainPresenter.renderViewPager(viewPagerDramaContainer)
            mainPresenter.renderViewPager(viewPagerActionContainer)
        }

        return binding.root
    }

}