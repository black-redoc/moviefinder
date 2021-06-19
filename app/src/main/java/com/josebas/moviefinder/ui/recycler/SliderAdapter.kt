package com.josebas.moviefinder.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flaviofaria.kenburnsview.KenBurnsView
import com.josebas.moviefinder.R
import com.josebas.moviefinder.domain.Movie

class SliderAdapter(private val dataSet: List<Movie>) :
    RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_container_slider, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.render(dataSet[position])

    override fun getItemCount(): Int = dataSet.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val movieTitle: TextView by lazy { view.findViewById(R.id.movieTitle) }
        private val kbsSlider: KenBurnsView = view.findViewById(R.id.kbvSlider)

        fun render(movie: Movie) {
            Glide
                .with(view)
                .load(movie.posterPath)
                .into(kbsSlider)

            movieTitle.text = movie.originalTitle
        }
    }

}
