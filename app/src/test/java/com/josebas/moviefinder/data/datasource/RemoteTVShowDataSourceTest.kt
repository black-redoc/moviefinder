package com.josebas.moviefinder.data.datasource

import com.josebas.moviefinder.data.datasource.remote.RemoteTVShowDataSource
import com.josebas.moviefinder.domain.remote.RemoteResultTVShow
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Response

internal class RemoteTVShowDataSourceTest {

    @Test
    fun `get popular tv show test`() {
        takeMockRequest {
            val popularTVShow: Response<RemoteResultTVShow> = runBlocking { getPopularTVShow() }
            assertNotNull(popularTVShow)
            assertTrue(popularTVShow.isSuccessful)
            assertEquals(popularTVShow.code(), 200)
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
    private fun takeMockRequest(requestCaller: RemoteTVShowDataSource.() -> Unit): RecordedRequest {
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
                requestCaller(RemoteTVShowDataSource(url))
                it.takeRequest()
            }
    }
}