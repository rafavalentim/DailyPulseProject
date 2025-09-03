package com.rafael.dailypulse

actual object Platform {
    actual val osName: String
        get() = "Web"
    actual val osVersion: String
        get() = "Web"
    actual val deviceModel: String
        get() = "Web"
    actual val density: String
        get() = "0"

    actual fun logSystemInfo() {
        println("($osName, $osVersion, $deviceModel, $density)")
    }
}