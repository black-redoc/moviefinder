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
import com.josebas.moviefinder.ui.recycler.SliderAdapter
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs

class HomeFragment : Fragment(), CoroutineScope {
    private lateinit var binding: FragmentHomeBinding
    private var job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        with(binding) {
            with(viewPagerContainer){
                adapter = SliderAdapter(InMemoryMovieDataSource.movies)

                clipToPadding = false
                clipChildren = false
                offscreenPageLimit = 3
                getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

                val transformer = CompositePageTransformer().apply {
                    addTransformer(MarginPageTransformer(40))
                    addTransformer  { page, position ->
                        val r = 1 - abs(position)
                        page.setScaleY( 0.95f + r * 0.05f)
                    }
                }

                setPageTransformer(transformer)
            }
        }

        return binding.root
    }

}