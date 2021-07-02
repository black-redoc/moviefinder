package com.josebas.moviefinder.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josebas.moviefinder.domain.MotionPicture

class MotionPictureDetailViewModel: ViewModel() {
    private val _motionPictureLiveData = MutableLiveData<MotionPicture>()

    val motionPictureLiveData: LiveData<MotionPicture>
        get() = _motionPictureLiveData

    fun setMovie(movie: MotionPicture) {
        _motionPictureLiveData.value = movie
    }
}