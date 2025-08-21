package com.rafael.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.rafael.dailypulse.db.DailyPulseDatabase
import com.rafael.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DailyPulseDatabase>{ DailyPulseDatabase(get()) }
}