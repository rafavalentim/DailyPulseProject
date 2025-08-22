package com.rafael.dailypulse.articles


class ArticlesRepository(
    private val datasource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(forceFetch : Boolean) : List<ArticlesRaw>{

        if(forceFetch){
            datasource.clearArticles()
            return fetchArticles()
        }

        val articlesDb = datasource.getAllArticles()
        println("Got ${articlesDb.size} from the database!!!")

        if(articlesDb.isEmpty()){
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticlesRaw> {
        val fetchedArticles = service.fetchArticles()
        datasource.insertArticles(fetchedArticles)
        return fetchedArticles
    }


}