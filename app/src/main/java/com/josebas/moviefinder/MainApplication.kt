package com.josebas.moviefinder

import android.app.Application
import com.josebas.moviefinder.data.datasource.GenresDataSourceImpl
import com.josebas.moviefinder.data.datasource.InMemoryMovieDataSource
import com.josebas.moviefinder.data.datasource.InMemoryTVShowDataSource
import com.josebas.moviefinder.data.repository.MovieRepository
import com.josebas.moviefinder.data.repository.TVShowRepository
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.ui.presenter.HomePresenter
import com.josebas.moviefinder.ui.viewmodel.MotionPictureDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class MainApplication : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(androidXModule(this@MainApplication))

        bind<GenresDataSource>() with singleton { GenresDataSourceImpl() }
        bind() from singleton { MovieRepository(InMemoryMovieDataSource(instance())) }
        bind() from singleton { TVShowRepository(InMemoryTVShowDataSource(instance())) }
        bind() from singleton { MotionPictureDetailViewModel() }
        bind() from provider { HomePresenter(instance(), instance(), instance()) }
    }
}