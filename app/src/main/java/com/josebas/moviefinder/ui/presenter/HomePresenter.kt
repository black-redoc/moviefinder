package com.josebas.moviefinder.ui.presenter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.josebas.moviefinder.domain.MotionPicture
import com.josebas.moviefinder.domain.Movie
import com.josebas.moviefinder.domain.datasource.InMemoryMovieDataSource
import com.josebas.moviefinder.domain.datasource.InMemoryTVShowDataSource
import com.josebas.moviefinder.ui.commons.MotionPictureType
import com.josebas.moviefinder.ui.commons.MovieType
import com.josebas.moviefinder.ui.commons.TVShowType
import com.josebas.moviefinder.ui.recycler.SliderAdapter
import com.josebas.moviefinder.ui.viewmodel.MotionPictureDetailViewModel
import kotlin.math.abs

class HomePresenter(private val motionPictureDetailViewModel: MotionPictureDetailViewModel) {
    private val inMemoryTVShowDataSource = InMemoryTVShowDataSource()
    private val inMemoryMovieDataSource = InMemoryMovieDataSource()

    fun renderViewPager(viewPagerContainer: ViewPager2, type: MotionPictureType) = with(viewPagerContainer) {

        adapter = when(type) {
            is MovieType -> SliderAdapter(
                inMemoryMovieDataSource.getMovies(), motionPictureDetailViewModel
            )
            is TVShowType -> SliderAdapter(
                inMemoryTVShowDataSource.getTVShow(), motionPictureDetailViewModel
            )
        }

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