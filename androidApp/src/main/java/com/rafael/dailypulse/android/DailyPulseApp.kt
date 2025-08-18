package com.rafael.dailypulse.android

import android.app.Application
import com.rafael.dailypulse.android.di.viewModelsModule
import com.rafael.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp: Application() {

    //Cirando uma função que inicializa o Koin
    override fun onCreate() {
        super.onCreate()
        initKoin()

    }

    //Inicializando o koin no contexto da aplicação.
    private fun initKoin(){
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }



    }



}