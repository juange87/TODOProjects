package com.juange.todoprojects.data.net.base

interface HttpResponseCodes {
    companion object {
        const val OK = 200
        const val UNAUTHORIZED = 401
        const val NOT_FOUND = 404
        const val SERVER_ERROR = 500
    }
}