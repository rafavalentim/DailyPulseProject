package com.rafael.dailypulse

expect object Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: String

   fun logSystemInfo()
}
