package com.rafael.dailypulse

import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.Foundation.NSLog

actual object Platform{

    actual val osName: String
        get() = UIDevice.currentDevice.systemName

    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion()

    actual val deviceModel: String
        get() = UIDevice.currentDevice.model

    actual val density: String
        get() = UIScreen.mainScreen.scale.toInt().toString()

    actual fun logSystemInfo(){
        NSLog(
            "Dayly Pulse Notices," +
                    "($osName, $osVersion, $deviceModel, $density)"
        )
    }
}