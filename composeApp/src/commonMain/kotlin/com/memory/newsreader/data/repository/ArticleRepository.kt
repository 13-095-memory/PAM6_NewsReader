package com.memory.newsreader.data.repository

import com.memory.newsreader.data.model.Article
import com.memory.newsreader.data.remote.ApiService

class ArticleRepository(private val apiService: ApiService) {

    suspend fun getTopHeadlines(): Result<List<Article>> {
        return try {
            val response = apiService.getTopHeadlines()
            Result.success(response.articles)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchNews(query: String): Result<List<Article>> {
        return try {
            val response = apiService.searchNews(query)
            Result.success(response.articles)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}