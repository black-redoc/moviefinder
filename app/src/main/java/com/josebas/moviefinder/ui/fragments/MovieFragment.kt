package com.josebas.moviefinder.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.josebas.moviefinder.R
import com.josebas.moviefinder.data.repository.MovieRepository
import com.josebas.moviefinder.databinding.FragmentMovieBinding
import com.josebas.moviefinder.ui.recycler.MotionPictureAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class MovieFragment : Fragment(), KodeinAware {
    override val kodein by closestKodein()
    private val movieRepository: MovieRepository by instance()
    private lateinit var binding: FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)

        loadRecyclerView()

        return binding.root
    }

    private fun loadRecyclerView(): Unit = with(binding) {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.IO) {
                movieRepository.getPopularMovies()
            }
            recyclerView.adapter = MotionPictureAdapter(movies)
            recyclerView.layoutManager = GridLayoutManager(context, 3)
            recyclerView.setHasFixedSize(true)
        }
    }
}