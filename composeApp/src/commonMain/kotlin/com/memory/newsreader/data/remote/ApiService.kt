package com.memory.newsreader.data.remote

import com.memory.newsreader.data.model.NewsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiService(private val client: HttpClient) {

    private val baseUrl = "https://gnews.io/api/v4"
    private val apiKey = "043584ec38d4c4d121cb8e9573e70ba9"

    suspend fun getTopHeadlines(): NewsResponse {
        return client.get("$baseUrl/top-headlines") {
            parameter("token", apiKey)
            parameter("lang", "en")
            parameter("max", 10)
        }.body()
    }

    suspend fun searchNews(query: String): NewsResponse {
        return client.get("$baseUrl/search") {
            parameter("token", apiKey)
            parameter("q", query)
            parameter("lang", "en")
            parameter("max", 10)
        }.body()
    }
}