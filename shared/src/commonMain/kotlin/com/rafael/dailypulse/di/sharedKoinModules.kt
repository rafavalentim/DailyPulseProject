package com.rafael.dailypulse.di

import com.rafael.dailypulse.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)