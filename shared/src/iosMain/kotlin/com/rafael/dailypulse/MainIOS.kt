package com.rafael.dailypulse

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.rafael.dailypulse.ui.screens.AboutScreen
import com.rafael.dailypulse.ui.screens.SourcesScreen

fun MainViewController() : UIViewController = ComposeUIViewController {
    //AboutScreen()
    SourcesScreen()
}