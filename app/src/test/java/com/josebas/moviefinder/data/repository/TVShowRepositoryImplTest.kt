package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.datasource.remote.RemoteTVShowDataSource
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.remote.RemoteResultTVShow
import com.josebas.moviefinder.domain.remote.RemoteTVShow
import org.junit.Assert.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
internal class TVShowRepositoryImplTest {
    @Mock
    private lateinit var remoteTVShowDataSource: RemoteTVShowDataSource

    @Mock
    private lateinit var genresDataSource: GenresDataSource

    @InjectMocks
    private lateinit var tvShowRepository: TVShowRepositoryImpl

    private val remoteTVShow = RemoteTVShow(
        "$BASE_URL/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg",
        listOf(35, 80),
        1,
        "TVShowTest tv show test overview...",
        "$BASE_URL/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
        "2021-05-26",
        "TVShowTest",
        "langTest",
        1f
    )

    @Before
    fun init() {
        tvShowRepository = TVShowRepositoryImpl(remoteTVShowDataSource, genresDataSource)
        val remoteResultTvShow = RemoteResultTVShow(listOf(remoteTVShow))

        runBlocking {
            `when`(remoteTVShowDataSource.getPopularTVShow()).thenReturn(Response.success(remoteResultTvShow))
        }
    }

    @Test
    fun `get popular tv show test`(): Unit = runBlocking {
        val popularTvShow = tvShowRepository.getPopularTVShow()
        assertNotNull(popularTvShow)
        assertNotEquals(popularTvShow.size, 0)
    }

    @Test
    fun `size of popular tv show must be 1 test`(): Unit = runBlocking {
        val popularTvShow = tvShowRepository.getPopularTVShow()
        assertEquals(popularTvShow.size, 1)
    }
}