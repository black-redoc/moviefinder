package com.josebas.moviefinder

import android.app.Application
import com.josebas.moviefinder.data.datasource.local.GenresDataSourceImpl
import com.josebas.moviefinder.data.datasource.local.InMemoryMovieDataSource
import com.josebas.moviefinder.data.datasource.local.InMemoryTVShowDataSource
import com.josebas.moviefinder.data.datasource.remote.RemoteMovieDataSource
import com.josebas.moviefinder.data.datasource.remote.RemoteTVShowDataSource
import com.josebas.moviefinder.data.repository.MovieRepository
import com.josebas.moviefinder.data.repository.MovieRepositoryImpl
import com.josebas.moviefinder.data.repository.TVShowRepository
import com.josebas.moviefinder.data.repository.TVShowRepositoryImpl
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.ui.fragments.HomeFragment
import com.josebas.moviefinder.ui.presenter.HomePresenter
import com.josebas.moviefinder.ui.presenter.MainPresenter
import com.josebas.moviefinder.ui.viewmodel.MotionPictureDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class MainApplication : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(androidXModule(this@MainApplication))

        bind<GenresDataSource>() with singleton { GenresDataSourceImpl() }
        bind<MovieRepository>() with singleton {
            MovieRepositoryImpl(
                RemoteMovieDataSource(),
                instance()
            )
        }
        bind<TVShowRepository>() with singleton {
            TVShowRepositoryImpl(
                RemoteTVShowDataSource.invoke(),
                instance()
            )
        }
        bind() from singleton { MotionPictureDetailViewModel() }
        bind() from provider { HomePresenter(instance()) }
        bind() from factory { view: MainPresenter.View -> MainPresenter(view) }
        bind() from provider { HomeFragment(instance(), instance(), instance()) }
    }
}