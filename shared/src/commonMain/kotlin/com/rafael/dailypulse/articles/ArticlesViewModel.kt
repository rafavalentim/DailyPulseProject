package com.rafael.dailypulse.articles

import com.rafael.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())

    val articlesState: StateFlow<ArticlesState> get() = _articlesState


    // Esse bloco de código sempre é executado ao inicializar a classe (Geralmente é a IU que inicializa a viewModel).
    init {

        getArticles()

    }

    private fun getArticles(){
        scope.launch {
            delay(500)
            _articlesState.emit(ArticlesState())
        }
    }
}