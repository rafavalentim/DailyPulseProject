package com.rafael.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.rafael.dailypulse.di.initKoin
import com.rafael.dailypulse.ui.App
import org.jetbrains.skia.Surface
import org.jetbrains.skiko.wasm.onWasmReady

val koin = initKoin()

@OptIn( ExperimentalComposeUiApi::class)
fun main(){

    CanvasBasedWindow("DailyPulse") {

        Surface(modifier = Modifier.fillMaxSize()){

            App(koin)

        }


    }

}