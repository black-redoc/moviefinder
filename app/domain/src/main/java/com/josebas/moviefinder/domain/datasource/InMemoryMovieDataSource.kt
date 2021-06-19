package com.josebas.moviefinder.domain.datasource

import com.josebas.moviefinder.domain.Genre
import com.josebas.moviefinder.domain.Movie
import java.time.LocalDate

const val baseImageUrl = "https://image.tmdb.org/t/p/w500"

object InMemoryMovieDataSource {
    val movies = listOf(
        Movie(
            337404,
            "en",
            "Cruella",
            """In 1970s London amidst the punk rock revolution, a young grifter named 
                |Estella is determined to make a name for herself with her designs. She 
                |befriends a pair of young thieves who appreciate her appetite for mischief, 
                |and together they are able to build a life for themselves on the London streets. 
                |One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, 
                |a fashion legend who is devastatingly chic and terrifyingly haute. But their 
                |relationship sets in motion a course of events and revelations that will cause 
                |Estella to embrace her wicked side and become the raucous, fashionable and 
                |revenge-bent Cruella.""".trimMargin(),
            "2021-05-26".toLocalDate(),
            "$baseImageUrl/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
            "$baseImageUrl/8ChCpCYxh9YXusmHwcE9YzP0TSG.jpg",
            listOf(35, 80).findGenres()
        ),
        Movie(
            423108,
            "en",
            "The Conjuring: The Devil Made Me Do It",
            """Paranormal investigators Ed and Lorraine Warren encounter what would become
                | one of the most sensational cases from their files. The fight for the soul of a 
                | young boy takes them beyond anything they'd ever seen before, to mark the first 
                | time in U.S. history that a murder suspect would claim demonic possession as a 
                | defense.""".trimMargin(),
            "2021-05-25".toLocalDate(),
            "$baseImageUrl/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
            "$baseImageUrl/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
            listOf(27,9648, 53).findGenres()
        ),
        Movie(
            637649,
            "en",
            "Wrath of Man",
            """A cold and mysterious new security guard for a Los Angeles cash truck 
                |company surprises his co-workers when he unleashes precision skills during a heist.
                | The crew is left wondering who he is and where he came from. Soon, the marksman's 
                | ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle
                |  a score.""".trimMargin(),
            "2021-04-22".toLocalDate(),
            "$baseImageUrl/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
            "$baseImageUrl/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
            listOf(80, 28).findGenres()
        ),
        Movie(
            717192,
            "nl",
            "Ferry",
            """Before he built a drug empire, Ferry Bouman returns to his hometown on 
                |a revenge mission that finds his loyalty tested — and a love that alters 
                |his life.""".trimMargin(),
            "2021-05-14".toLocalDate(),
            "$baseImageUrl/w6n1pu9thpCVHILejsuhKf3tNCV.jpg",
            "$baseImageUrl/fejok33Ijc6SppiEU1cfwA9Mo2.jpg",
            listOf(28, 80, 18).findGenres()
        ),
        Movie(
            804435,
            "en",
            "Vanquish",
            """Victoria is a young mother trying to put her dark past as a Russian drug 
                |courier behind her, but retired cop Damon forces Victoria to do his bidding by 
                |holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle 
                |to take out a series of violent gangsters—or she may never see her 
                |child again.""".trimMargin() ,
            "2021-04-16".toLocalDate(),
            "$baseImageUrl/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
            "$baseImageUrl/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg",
            listOf(28, 80, 53).findGenres()
        ),
        Movie(
            399566,
            "en",
            "Godzilla vs. Kong",
            """In a time when monsters walk the Earth, humanity’s fight for its future sets 
                |Godzilla and Kong on a collision course that will see the two most powerful 
                |forces of nature on the planet collide in a spectacular battle for 
                |the ages.""".trimMargin(),
            "2021-03-24".toLocalDate(),
            "$baseImageUrl/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "$baseImageUrl/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
            listOf(28, 878, 12).findGenres()
        )
    )
}

fun String.toLocalDate(): LocalDate = LocalDate.parse(this)

fun List<Int>.findGenres(): List<Genre> = this.map {
    GenresDataSource.genres.find { genre -> it == genre.id } ?: Genre(0, "No genre found")
}
