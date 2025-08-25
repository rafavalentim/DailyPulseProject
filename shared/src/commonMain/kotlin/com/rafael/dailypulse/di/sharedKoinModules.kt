package com.rafael.dailypulse.di

import com.rafael.dailypulse.articles.di.articlesModule
import com.rafael.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule
)