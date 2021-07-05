package com.josebas.moviefinder.domain.local

import com.josebas.moviefinder.domain.Genre

interface MotionPicture {
    val id: Int
    val originalLanguage: String
    val overview: String
    val posterPath: String?
    val backdropPath: String?
    val genres: List<Genre>
}