package com.rafael.dailypulse.articles.di

import com.rafael.dailypulse.articles.ArticlesDataSource
import com.rafael.dailypulse.articles.ArticlesRepository
import com.rafael.dailypulse.articles.ArticlesService
import com.rafael.dailypulse.articles.ArticlesUseCase
import com.rafael.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

//Creating the injection dependency.
val articlesModule = module {

    single <ArticlesService>{ArticlesService(get())}
    single<ArticlesUseCase>{ ArticlesUseCase(get()) }
    single<ArticlesViewModel>{ ArticlesViewModel(get()) }
    single<ArticlesDataSource>{ ArticlesDataSource(get()) }
    single<ArticlesRepository>{ ArticlesRepository(get(), get()) }


}