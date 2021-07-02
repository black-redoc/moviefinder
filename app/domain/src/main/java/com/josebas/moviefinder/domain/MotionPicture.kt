package com.josebas.moviefinder.domain

interface MotionPicture {
    val id: Int
    val originalLanguage: String
    val overview: String
    val posterPath: String?
    val backdropPath: String?
    val genres: List<Genre>
}