package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.common.toLocalTVShows
import com.josebas.moviefinder.data.datasource.remote.RemoteTVShowDataSource
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.local.TVShow

class TVShowRepositoryImpl(
    private val remoteTVShowDataSource: RemoteTVShowDataSource,
    private val genresDataSource: GenresDataSource
): TVShowRepository {

    override suspend fun getPopularTVShow(): List<TVShow> = with(remoteTVShowDataSource.getPopularTVShow()) {
        return body()!!.results.toLocalTVShows(genresDataSource)
    }
}