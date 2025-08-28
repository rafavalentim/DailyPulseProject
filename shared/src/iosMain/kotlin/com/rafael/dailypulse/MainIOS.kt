package com.rafael.dailypulse

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.rafael.dailypulse.ui.screens.ArticlesScreen

fun MainViewController() : UIViewController = ComposeUIViewController {

    ArticlesScreen()
}