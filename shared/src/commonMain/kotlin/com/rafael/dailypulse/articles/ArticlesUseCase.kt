package com.rafael.dailypulse.articles

import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

//Classe responsável por mapear oa dados do response nas classes de negócio do sistema.
class ArticlesUseCase(private val repo : ArticlesRepository) {

    suspend fun getArticles() : List<Article>{
        val articlesRaw = repo.getArticles()

        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticlesRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: "Click to find out more",
            getDaysAgoString(raw.date),
            raw.imageUrl ?:"https://images.unsplash.com/photo-1609743522653-52354461eb27?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        )
    }

    @OptIn(ExperimentalTime::class)
    private fun getDaysAgoString(date : String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${days} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return  result


    }
}