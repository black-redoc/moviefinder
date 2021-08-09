package com.josebas.moviefinder.data.datasource

import com.josebas.moviefinder.data.datasource.remote.RemoteMovieDataSource
import com.josebas.moviefinder.domain.remote.RemoteResultMovie
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.Assert.*
import org.junit.Test

internal class RemoteMovieDataSourceTest {

    @Test
    fun `get top rated movies test`() {
        takeMockRequest {
            val topRatedMovies: Response<RemoteResultMovie>  = runBlocking { getTopRatedMovies() }
            assertNotNull(topRatedMovies)
            assertTrue(topRatedMovies.isSuccessful)
            assertEquals(topRatedMovies.code(), 200)
        }
    }

    @Test
    fun `get popular movies test`() {
        takeMockRequest {
            val popularMovies: Response<RemoteResultMovie> = runBlocking { getPopularMovies() }
            assertNotNull(popularMovies)
            assertTrue(popularMovies.isSuccessful)
            assertEquals(popularMovies.code(), 200)
        }
    }

    @Test
    fun `get up coming movies test`() {
        takeMockRequest {
            val upComingMovies: Response<RemoteResultMovie>  = runBlocking { getUpComingMovies() }
            assertNotNull(upComingMovies)
            assertTrue(upComingMovies.isSuccessful)
            assertEquals(upComingMovies.code(), 200)
        }
    }

    /**
     * takeMockRequest
     *
     * Wrap the retrofit api call (RemoteDataSource) into the MockWebServer.
     *
     * @param requestCaller the callback wrapped into the mock request.
     * @return RecordedRequest.
     */
    private fun takeMockRequest(requestCaller: RemoteMovieDataSource.() -> Unit): RecordedRequest {
        return MockWebServer()
            .use {
                it.enqueue(MockResponse().apply {
                    setBody(
                        """
                        {
                            "results": []
                        }
                    """.trimIndent()
                    )
                })
                it.start()
                val url = it.url("/")
                requestCaller(RemoteMovieDataSource(url))
                it.takeRequest()
            }
    }
}