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
import com.josebas.moviefinder.domain.local.MotionPicture
import com.josebas.moviefinder.domain.local.Movie
import com.josebas.moviefinder.domain.local.TVShow
import com.josebas.moviefinder.ui.fragments.MotionPictureDetailFragment
import com.josebas.moviefinder.ui.viewmodel.MotionPictureDetailViewModel

class SliderAdapter(
    private val dataSet: List<MotionPicture>,
    private val motionPictureDetailViewModel: MotionPictureDetailViewModel
) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_container_slider, parent, false)
        return ViewHolder(view, motionPictureDetailViewModel)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.render(dataSet[position])

    override fun getItemCount(): Int = dataSet.size

    class ViewHolder(
        private val view: View,
        private val motionPictureDetailViewModel: MotionPictureDetailViewModel
    ) : RecyclerView.ViewHolder(view) {
        private val movieTitle: TextView by lazy { view.findViewById(R.id.movieTitle) }
        private val cardView: CardView by lazy { view.findViewById(R.id.cardView) }
        private val kbsSlider: KenBurnsView = view.findViewById(R.id.kbvSlider)

        fun render(motion: MotionPicture) {
            Glide
                .with(view)
                .load(motion.posterPath)
                .placeholder(R.drawable.ic_image_not_found)
                .into(kbsSlider)

            when (motion) {
                is Movie -> movieTitle.text = motion.originalTitle
                is TVShow -> movieTitle.text = motion.originalName
            }

            cardView.setOnClickListener {
                motionPictureDetailViewModel.setMovie(motion)
                val activity = view.context as AppCompatActivity
                activity
                    .supportFragmentManager
                    .beginTransaction().run {
                        val movieDetailFragment = MotionPictureDetailFragment()
                        replace(R.id.fragment_container, movieDetailFragment)
                        commit()
                    }
            }
        }
    }
}
