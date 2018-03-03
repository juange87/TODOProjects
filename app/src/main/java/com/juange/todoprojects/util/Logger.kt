package com.juange.todoprojects.util

import android.util.Log
import com.juange.todoprojects.BuildConfig

object Logger {

    private const val TAG = "TODOPROJECTS"

    fun i(string: String) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, string)
        }
    }

    fun e(string: String) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, string)
        }
    }

    fun e(string: String, e: Throwable) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, string, e)
        }
    }

    fun d(string: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, string)
        }
    }

    fun v(string: String) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, string)
        }
    }

    fun w(string: String) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, string)
        }
    }
}
