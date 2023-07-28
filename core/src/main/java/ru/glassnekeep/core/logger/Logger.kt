package ru.glassnekeep.core.logger

import android.util.Log

object Logger {

    private const val TAG = "Animori"

    fun e(e: Throwable) = Log.e(TAG, e.message, e)

    fun e(e: Throwable, tag: String) = Log.e(tag, e.message, e)

    fun e(e: Throwable, tag: String, msg: String) = Log.d(TAG, msg, e)

    fun i(msg: String) = Log.i(TAG, msg)

    fun i(tag: String, msg: String) = Log.i(tag, msg)

    fun d(msg: String) = Log.d(TAG, msg)

    fun d(tag: String, msg: String) = Log.d(tag, msg)
}