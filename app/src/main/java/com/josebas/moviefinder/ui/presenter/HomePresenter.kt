package com.josebas.moviefinder.ui.presenter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.josebas.moviefinder.domain.datasource.InMemoryMovieDataSource
import com.josebas.moviefinder.ui.recycler.SliderAdapter
import kotlin.math.abs

class HomePresenter {

    fun renderViewPager(viewPagerContainer: ViewPager2) = with(viewPagerContainer) {
        adapter = SliderAdapter(InMemoryMovieDataSource.movies)

        clipToPadding = false
        clipChildren = false
        offscreenPageLimit = 3
        getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val transformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
            addTransformer  { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.95f + r * 0.05f
            }
        }

        setPageTransformer(transformer)
    }
}