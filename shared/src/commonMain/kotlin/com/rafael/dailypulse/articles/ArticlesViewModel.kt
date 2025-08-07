package com.rafael.dailypulse.articles

import com.rafael.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState


    // Esse bloco de código sempre é executado ao inicializar a classe (Geralmente é a IU que inicializa a viewModel).
    init {

        getArticles()

    }

    private fun getArticles(){
        scope.launch {

            val fetchedArticles = fetchArticles()

            delay(500)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    //Teste para simular o retorno de uma api com os artigos:
    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            "Mock Market today: Live Updates",
            "Future wew higher in premarket tradind as Wall Street tried to regain its footing",
            "2023-11-09",
            "https://images.pexels.com/photos/1737957/pexels-photo-1737957.jpeg"

        ),
        Article(
            "Best Iphone deals (2023)",
            "Apple's smartphones rarelu go on sale",
            "2023-11-09",
            "https://images.pexels.com/photos/13367286/pexels-photo-13367286.jpeg"

        ),
        Article(
            "Samsung detais",
            "New blos post, samsung previewed what it calls a new era of galaxy AI",
            "2023-11-09",
            "https://images.pexels.com/photos/2402705/pexels-photo-2402705.jpeg"

        )
    )


}