package com.josebas.moviefinder.domain.remote

data class RemoteTVShow(
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val overview: String,
    val poster_path: String?,
    val first_air_Date: String?,
    val original_name: String,
): RemoteMotionPicture()
