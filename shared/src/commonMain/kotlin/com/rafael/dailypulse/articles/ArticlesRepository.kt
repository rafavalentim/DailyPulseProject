package com.rafael.dailypulse.articles


class ArticlesRepository(
    private val datasource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles() : List<ArticlesRaw>{

        val articlesDb = datasource.getAllArticles()
        println("Got ${articlesDb.size} from the database!!!")

        if(articlesDb.isEmpty()){
            val fetchedArticles = service.fetchArticles()
            datasource.insertArticles(fetchedArticles)
            return  fetchedArticles
        }
        return articlesDb
    }



}