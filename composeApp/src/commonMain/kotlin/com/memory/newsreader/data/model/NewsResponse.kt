package com.memory.newsreader.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val totalArticles: Int,
    val articles: List<Article>
)