package com.josebas.moviefinder.data.datasource

import com.josebas.moviefinder.domain.local.TVShow
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.common.baseImageUrl
import com.josebas.moviefinder.domain.common.findGenres
import com.josebas.moviefinder.domain.common.toLocalDate

class InMemoryTVShowDataSource(genresDataSource: GenresDataSource) {

    private val tvShows = listOf(
        TVShow(
            84958,
            "en",
            "Loki",
            """After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate 
                |version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic
                |organization that exists outside of time and space and monitors the timeline. They 
                |give Loki a choice: face being erased from existence due to being a “time variant”or 
                |help fix the timeline and stop a greater threat.""".trimMargin(),
            9580.138F,
            "$baseImageUrl/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            "$baseImageUrl/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            "2020-10-20".toLocalDate(),
            listOf(18, 10765).findGenres(genresDataSource)
        ),
        TVShow(
            119243,
            "en",
            "iCarly",
            """Ten years after signing off of one of TV's most iconic shows, Carly, Spencer, and 
                |Freddie are back, navigating the next chapter of their lives, facing the uncertainties 
                |of life in their twenties""".trimMargin(),
            9580.138F,
            "$baseImageUrl/s5k4GqTUGXeUdScNrjpYfiQLKHI.jpg",
            "$baseImageUrl/5b5ZZGECl4FLDBKn3zJ6w6GBPRg.jpg",
            "2020-10-20".toLocalDate(),
            listOf(35, 18).findGenres(genresDataSource)
        ),
        TVShow(
            60625,
            "en",
            "Rick and Morty",
            """Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected 
                |with his family. He spends most of his time involving his young grandson Morty in dangerous, 
                |outlandish adventures throughout space and alternate universes. Compounded with Morty's 
                |already unstable family life, these events cause Morty much distress at home and 
                |school.""".trimMargin(),
            1157.562F,
            "$baseImageUrl/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
            "$baseImageUrl/eV3XnUul4UfIivz3kxgeIozeo50.jpg",
            "2020-10-20".toLocalDate(),
            listOf(16, 35, 10765, 10759).findGenres(genresDataSource)
        ),
    )

    fun getTVShow(): List<TVShow> = tvShows
}