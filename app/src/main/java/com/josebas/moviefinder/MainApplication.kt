package com.josebas.moviefinder

import android.app.Application
import com.josebas.moviefinder.ui.viewmodel.MovieDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MainApplication : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(androidXModule(this@MainApplication))

        bind<MovieDetailViewModel>() with singleton { instance() }
    }
}