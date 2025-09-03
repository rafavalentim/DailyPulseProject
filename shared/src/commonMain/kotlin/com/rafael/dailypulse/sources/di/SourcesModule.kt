package com.rafael.dailypulse.sources.di

import com.rafael.dailypulse.sources.application.SourcesUseCase
import com.rafael.dailypulse.sources.data.SourcesDataSource
import com.rafael.dailypulse.sources.data.SourcesRepository
import com.rafael.dailypulse.sources.data.SourcesService
import com.rafael.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {

    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesDataSource> { SourcesDataSource(getOrNull()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}