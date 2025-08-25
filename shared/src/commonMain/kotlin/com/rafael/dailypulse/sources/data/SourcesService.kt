package com.rafael.dailypulse.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    private val apiKey = "85a2ff51c7d64fe08cbf5449e8f1b73b"
    suspend fun fetchSources(): List<SourceRaw> {

        val response: SourcesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}