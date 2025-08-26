package com.rafael.dailypulse

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.rafael.dailypulse.ui.App

fun MainViewController() : UIViewController = ComposeUIViewController {
    App()
}