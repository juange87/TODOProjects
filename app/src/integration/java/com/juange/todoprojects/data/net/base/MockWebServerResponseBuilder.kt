package com.juange.todoprojects.data.net.base

import okhttp3.mockwebserver.MockResponse
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection

class MockWebServerResponseBuilder() {
    private val mockResponse: MockResponse = MockResponse()

    constructor(code: Int) : this() {
        mockResponse.setResponseCode(code)
    }

    fun httpCode200(): MockWebServerResponseBuilder {
        mockResponse.setResponseCode(HttpURLConnection.HTTP_OK)
        return this
    }

    fun httpCode404(): MockWebServerResponseBuilder {
        mockResponse.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
        return this
    }

    fun httpCode401(): MockWebServerResponseBuilder {
        mockResponse.setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
        return this
    }

    fun httpCode500(): MockWebServerResponseBuilder {
        mockResponse.setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
        return this
    }

    fun body(body: String): MockWebServerResponseBuilder {
        mockResponse.setBody(body)
        return this
    }

    fun bodyFromFile(path: String): MockWebServerResponseBuilder {
        val body = getStringFromFile(path)
        mockResponse.setBody(body)
        return this
    }

    fun build(): MockResponse {
        return mockResponse
    }

    private fun getStringFromFile(path: String): String {
        try {
            val resourceAsStream = javaClass.classLoader.getResourceAsStream(path)
            return getStringFromStream(resourceAsStream)
        } catch (exception: IOException) {
            throw RuntimeException(exception)
        }
    }

    @Throws(IOException::class)
    private fun getStringFromStream(input: InputStream): String {
        val inputStreamReader = InputStreamReader(input, STRING_ENCODING)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder = StringBuilder()
        var line: String? = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = bufferedReader.readLine()
        }
        bufferedReader.close()
        inputStreamReader.close()
        return stringBuilder.toString()
    }

    companion object {
        private const val STRING_ENCODING = "UTF-8"
    }
}
