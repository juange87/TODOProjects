package com.juange.todoprojects.data.net.base

import io.mockk.mockk
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseApiTest {

    var server = MockWebServer()
    lateinit var netConnectivityManager: NetConnectivityManager
    lateinit var endpoint: HttpUrl
    abstract fun onInit()

    @Before
    fun setUp() {
        server.start()
        endpoint = server.url(URL)

        netConnectivityManager = mockk<NetConnectivityManager>()
        onInit()
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    fun createRetrofitClient(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("$endpoint")
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {
        const val URL = "/"
    }
}