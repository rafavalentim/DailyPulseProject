package com.rafael.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual object Platform{

    actual val osName: String
        get() = "Android"

    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"

    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"

    actual val density: String
        get() = round(Resources.getSystem().displayMetrics.density).toInt().toString()

    actual fun logSystemInfo(){
        Log.d(
            "Dayly Pulse Notices",
            "(${osName}, ${osVersion}, ${deviceModel}, ${density})"
        )

    }
}