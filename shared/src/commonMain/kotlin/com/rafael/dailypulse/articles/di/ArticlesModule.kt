package com.rafael.dailypulse.articles.di

import com.rafael.dailypulse.articles.data.ArticlesDataSource
import com.rafael.dailypulse.articles.data.ArticlesRepository
import com.rafael.dailypulse.articles.data.ArticlesService
import com.rafael.dailypulse.articles.application.ArticlesUseCase
import com.rafael.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

//Creating the injection dependency.
val articlesModule = module {

    single <ArticlesService>{ArticlesService(get())}
    single<ArticlesUseCase>{ ArticlesUseCase(get()) }
    single<ArticlesViewModel>{ ArticlesViewModel(get()) }
    single<ArticlesDataSource>{ ArticlesDataSource(getOrNull()) }
    single<ArticlesRepository>{ ArticlesRepository(get(), get()) }


}