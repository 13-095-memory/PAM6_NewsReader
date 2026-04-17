package com.memory.newsreader

import androidx.compose.runtime.*
import androidx.compose.material3.MaterialTheme
import com.memory.newsreader.data.model.Article
import com.memory.newsreader.ui.screen.DetailScreen
import com.memory.newsreader.ui.screen.NewsScreen

@Composable
fun App() {
    MaterialTheme {
        var selectedArticle by remember { mutableStateOf<Article?>(null) }

        if (selectedArticle != null) {
            DetailScreen(
                article = selectedArticle!!,
                onBack = { selectedArticle = null }
            )
        } else {
            NewsScreen(
                onArticleClick = { article ->
                    selectedArticle = article
                }
            )
        }
    }
}