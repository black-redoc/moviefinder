package com.josebas.moviefinder.ui.fragments

import android.os.Bundle
//import com.josebas.moviefinder.R
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.josebas.moviefinder.R
import com.josebas.moviefinder.databinding.MovieDetailFragmentBinding
import com.josebas.moviefinder.ui.viewmodel.MovieDetailViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MovieDetailFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModel by instance<MovieDetailViewModel>()
    private lateinit var binding: MovieDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false)

        with(binding) {
            viewModel.movieData.observe(viewLifecycleOwner, {
                collapsingToolbar.title = it.originalTitle
                overview.text = it.overview
                Glide
                    .with(this@MovieDetailFragment)
                    .load(it.posterPath)
                    .placeholder(R.drawable.image_placeholder)
                    .into(posterImage)

                backButton.setOnClickListener {
                    parentFragmentManager.beginTransaction().run {
                        replace(R.id.fragment_container, HomeFragment())
                        commit()
                    }
                }
            })
        }

        return binding.root
    }
}