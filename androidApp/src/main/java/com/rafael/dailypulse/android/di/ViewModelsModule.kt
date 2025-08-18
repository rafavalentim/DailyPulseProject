package com.rafael.dailypulse.android.di

import com.rafael.dailypulse.articles.ArticlesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module{

    viewModel{ ArticlesViewModel(get()) }

}