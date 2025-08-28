package com.rafael.dailypulse

import androidx.compose.ui.window.ComposeUIViewController
import com.rafael.dailypulse.ui.App
import platform.UIKit.UIViewController

fun MainViewController() : UIViewController = ComposeUIViewController {

    App()
}