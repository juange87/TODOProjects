package com.juange.todoprojects.data.net.base

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetConnectivityManager @Inject constructor(private val context: Context) {

    fun internetConnectionAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
}
