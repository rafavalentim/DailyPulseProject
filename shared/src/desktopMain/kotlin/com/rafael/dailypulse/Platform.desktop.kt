package com.rafael.dailypulse

actual object Platform {
    actual val osName: String
        get() = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion: String
        get() = System.getProperty("os.version") ?: "---"
    actual val deviceModel: String
        get() = "Desktop"
    actual val density: String
        get() = "0"

    actual fun logSystemInfo() {
        println("($osName, $osVersion, $deviceModel, $density)")

    }
}