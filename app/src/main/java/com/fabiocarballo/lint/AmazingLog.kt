package com.fabiocarballo.lint

import android.util.Log

/**
 * This is a wrapper of android.util.Log that "prettifies" the logging message. This was just created
 * to showcase purposes of the [AndroidLogDetector]
 */
@Suppress("AndroidLogDetector")
object AmazingLog {

    fun v(message: String) = Log.v(TAG, message.prettify())

    fun d(message: String) = Log.d(TAG, message.prettify())

    fun w(message: String) = Log.w(TAG, message.prettify())

    fun i(message: String) = Log.i(TAG, message.prettify())

    fun wtf(message: String) = Log.wtf(TAG, message.prettify())

    fun e(message: String) = Log.e(TAG, message.prettify())

    private fun String.prettify() = "*^*^$this^*^*"

    private const val TAG = "AmazingLog"
}