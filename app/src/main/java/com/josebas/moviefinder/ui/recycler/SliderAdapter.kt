package com.josebas.moviefinder.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flaviofaria.kenburnsview.KenBurnsView
import com.josebas.moviefinder.R
import com.josebas.moviefinder.domain.Movie
import com.josebas.moviefinder.ui.fragments.MovieDetailFragment
import com.josebas.moviefinder.ui.viewmodel.MovieDetailViewModel

class SliderAdapter(
    private val dataSet: List<Movie>,
    private val movieDetailViewModel: MovieDetailViewModel
) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_container_slider, parent, false)
        return ViewHolder(view, movieDetailViewModel)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.render(dataSet[position])

    override fun getItemCount(): Int = dataSet.size

    class ViewHolder(
        private val view: View,
        private val movieDetailViewModel: MovieDetailViewModel
    ) : RecyclerView.ViewHolder(view) {
        private val movieTitle: TextView by lazy { view.findViewById(R.id.movieTitle) }
        private val cardView: CardView by lazy { view.findViewById(R.id.cardView) }
        private val kbsSlider: KenBurnsView = view.findViewById(R.id.kbvSlider)

        fun render(movie: Movie) {
            Glide
                .with(view)
                .load(movie.posterPath)
                .placeholder(R.drawable.image_placeholder)
                .into(kbsSlider)

            movieTitle.text = movie.originalTitle
            cardView.setOnClickListener {
                movieDetailViewModel.setMovie(movie)
                val activity = view.context as AppCompatActivity
                activity
                    .supportFragmentManager
                    .beginTransaction().run {
                        val movieDetailFragment = MovieDetailFragment()
                        replace(R.id.fragment_container, movieDetailFragment)
                        commit()
                    }
            }
        }
    }
}
