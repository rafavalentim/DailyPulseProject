package com.rafael.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "85a2ff51c7d64fe08cbf5449e8f1b73b"

    suspend fun fetchArticles(): List<ArticlesRaw>{
        val response : ArticlesResponse = httpClient.get("https://newapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()

        return response.articles
    }

}