package com.rafael.dailypulse.articles

//Classe responsável por mapear oa dados do response nas classes de negócio do sistema.
class ArticlesUseCase(private val service : ArticlesService) {

    suspend fun getArticles() : List<Article>{
        val articlesRaw = service.fetchArticles()

        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticlesRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: "Click to find out more",
            raw.date,
            raw.imageUrl ?:"https://images.unsplash.com/photo-1609743522653-52354461eb27?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        )
    }
}