package com.memory.newsreader.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memory.newsreader.data.model.Article
import com.memory.newsreader.data.remote.ApiService
import com.memory.newsreader.data.remote.HttpClientFactory
import com.memory.newsreader.data.repository.ArticleRepository
import com.memory.newsreader.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = ArticleRepository(
        ApiService(HttpClientFactory.create())
    )

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>> = _uiState.asStateFlow()

    init {
        loadNews()
    }

    fun loadNews() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getTopHeadlines()
                .onSuccess { articles ->
                    _uiState.value = UiState.Success(articles)
                }
                .onFailure { error ->
                    println("ERROR: ${error.message}") // ← tambah ini
                    println("ERROR CAUSE: ${error.cause}")
                    _uiState.value = UiState.Error(
                        error.message ?: "Gagal memuat berita"
                    )
                }
        }
    }

    fun refresh() = loadNews()
}