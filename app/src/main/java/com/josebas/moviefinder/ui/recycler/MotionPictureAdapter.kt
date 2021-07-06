package com.josebas.moviefinder.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.josebas.moviefinder.R
import com.josebas.moviefinder.domain.local.MotionPicture

class MotionPictureAdapter(
    private val motionPictureList: List<MotionPicture>
): RecyclerView.Adapter<MotionPictureAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val view: View,
    ): RecyclerView.ViewHolder(view) {
        private val posterImage: ImageView = view.findViewById(R.id.posterImage)

        fun render(motionPicture: MotionPicture) {
            Glide
                .with(view)
                .load(motionPicture.posterPath)
                .placeholder(R.drawable.ic_image_not_found)
                .into(posterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(motionPictureList[position])
    }

    override fun getItemCount(): Int = motionPictureList.size
}