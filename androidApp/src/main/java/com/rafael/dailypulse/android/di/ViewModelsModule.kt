package com.rafael.dailypulse.android.di

import com.rafael.dailypulse.articles.presentation.ArticlesViewModel
import com.rafael.dailypulse.sources.presentation.SourcesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module{

    viewModel{ ArticlesViewModel(get()) }
    viewModel{ SourcesViewModel(get()) }

}