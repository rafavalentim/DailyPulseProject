package com.rafael.dailypulse

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.rafael.dailypulse.ui.screens.AboutScreen

fun MainViewController() : UIViewController = ComposeUIViewController {
    AboutScreen()
}