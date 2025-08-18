package com.rafael.dailypulse.articles.di

import com.rafael.dailypulse.articles.ArticlesService
import com.rafael.dailypulse.articles.ArticlesUseCase
import com.rafael.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

//Creating the injection dependency.
val articlesModule = module {

    single <ArticlesService>{ArticlesService(get())}
    single<ArticlesUseCase>{ ArticlesUseCase(get()) }
    single<ArticlesViewModel>{ ArticlesViewModel(get()) }


}