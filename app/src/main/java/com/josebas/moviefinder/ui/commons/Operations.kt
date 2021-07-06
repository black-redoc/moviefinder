package com.josebas.moviefinder.ui.commons

val String.capital: String get() = this.lowercase().replaceFirstChar { char -> char.uppercase() }