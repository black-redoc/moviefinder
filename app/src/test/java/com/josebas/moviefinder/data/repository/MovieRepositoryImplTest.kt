package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.datasource.remote.RemoteMovieDataSource
import org.junit.Test
import org.junit.Assert.*

import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.remote.RemoteMovie
import com.josebas.moviefinder.domain.remote.RemoteResultMovie
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

const val BASE_URL = "http://www.test.com"

@RunWith(MockitoJUnitRunner::class)
internal class MovieRepositoryImplTest {
    @Mock
    lateinit var remoteMovieDataSource: RemoteMovieDataSource

    @Mock
    lateinit var genresDataSource: GenresDataSource

    @InjectMocks
    lateinit var movieRepository: MovieRepositoryImpl

    private val remoteMovie = RemoteMovie(
        "$BASE_URL/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg",
        listOf(35, 80),
        1,
        "MovieTest",
        "langTest",
        "movie test overview...",
        "$BASE_URL/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
        "2021-05-26"
    )

    @Before
    fun init() {
        movieRepository = MovieRepositoryImpl(remoteMovieDataSource, genresDataSource)
        val remoteResultMovie = RemoteResultMovie(listOf(remoteMovie))

        runBlocking {
            `when`(remoteMovieDataSource.getPopularMovies()).thenReturn(remoteResultMovie)
            `when`(remoteMovieDataSource.getTopRatedMovies()).thenReturn(remoteResultMovie)
            `when`(remoteMovieDataSource.getUpComingMovies()).thenReturn(remoteResultMovie)
        }
    }

    @Test
    fun `get popular movies test`(): Unit = runBlocking {
        val popularMovies = movieRepository.getPopularMovies()
        assertNotNull(popularMovies)
        assertNotEquals(popularMovies.size, 0)
    }

    @Test
    fun `size of popular movies must be 1 test`(): Unit = runBlocking {
        val popularMovies = movieRepository.getPopularMovies()
        assertEquals(popularMovies.size, 1)
    }

    @Test
    fun `get rated movies test`(): Unit = runBlocking {
        val ratedMovies = movieRepository.getRatedMovies()
        assertNotNull(ratedMovies)
        assertNotEquals(ratedMovies.size, 0)
    }

    @Test
    fun `size of rated movies must be 1 test`(): Unit = runBlocking {
        val ratedMovies = movieRepository.getRatedMovies()
        assertEquals(ratedMovies.size, 1)
    }

    @Test
    fun `get upcoming movies test`(): Unit = runBlocking {
        val upComingMovies = movieRepository.getUpComingMovies()
        assertNotNull(upComingMovies)
        assertNotEquals(upComingMovies.size, 0)
    }

    @Test
    fun `size of upcoming movies must be 1 test`(): Unit = runBlocking {
        val upComingMovies = movieRepository.getUpComingMovies()
        assertEquals(upComingMovies.size, 1)
    }
}