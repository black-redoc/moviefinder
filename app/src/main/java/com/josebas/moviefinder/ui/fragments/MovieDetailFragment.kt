package com.josebas.moviefinder.ui.fragments

import android.os.Bundle
//import com.josebas.moviefinder.R
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.josebas.moviefinder.R
import com.josebas.moviefinder.databinding.MovieDetailFragmentBinding
import com.josebas.moviefinder.domain.Movie
import com.josebas.moviefinder.domain.TVShow
import com.josebas.moviefinder.ui.viewmodel.MotionPictureDetailViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MovieDetailFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModel by instance<MotionPictureDetailViewModel>()
    private lateinit var binding: MovieDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false)

        loadMovies()

        return binding.root
    }

    private fun loadMovies() {
        with(binding) {
            val mainActivity = activity as AppCompatActivity

            mainActivity.setSupportActionBar(toolbar)
            mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

            toolbar.setNavigationOnClickListener {
                parentFragmentManager.beginTransaction().run {
                    replace(R.id.fragment_container, HomeFragment())
                    commit()
                }
            }

            viewModel.motionPictureLiveData.observe(viewLifecycleOwner, {
                when(it) {
                    is Movie -> collapsingToolbar.title = it.originalTitle
                    is TVShow -> collapsingToolbar.title = it.originalName
                }

                overview.text = it.overview
                Glide
                    .with(this@MovieDetailFragment)
                    .load(it.posterPath)
                    .placeholder(R.drawable.image_placeholder)
                    .into(posterImage)
            })
        }
    }
}