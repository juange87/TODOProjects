package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.di.ApiModule
import com.juange.todoprojects.data.net.base.HttpResponseCodes
import com.juange.todoprojects.data.net.base.NetConnectivityManager
import com.juange.todoprojects.data.net.task.model.TaskApiModel
import com.juange.todoprojects.data.net.task.model.TaskApiModelResponse
import com.juange.todoprojects.exceptions.InternetNotReachableException
import com.juange.todoprojects.exceptions.NotAuthorizedException
import com.juange.todoprojects.exceptions.NotFoundException
import com.juange.todoprojects.exceptions.ServerErrorException
import com.juange.todoprojects.util.Logger
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class TaskApiImpl @Inject constructor(
        @Named(ApiModule.TASK_SERVICE) private val service: TaskService,
        private val connectivityManager: NetConnectivityManager
) : TaskApi {

    override fun getTasksByProject(projectId: Int): List<TaskApiModel> {
        if (connectivityManager.internetConnectionAvailable()) {
            try {
                val call: Call<TaskApiModelResponse> = service.getTasksByProject(projectId)
                val response: Response<TaskApiModelResponse> = call.execute()

                val headers = response.headers()
                Logger.i("HEADERS: " + headers.toString())

                val responseCode = response.code()
                Logger.i("CODE: $responseCode")

                val success = response.isSuccessful
                Logger.i("SUCCESS: $success")

                val message = response.message()
                Logger.i("MESSAGE: $message")

                return when (responseCode) {
                    HttpResponseCodes.OK -> response.body()?.tasks ?: emptyList()
                    HttpResponseCodes.NOT_FOUND -> throw NotFoundException()
                    HttpResponseCodes.SERVER_ERROR -> throw ServerErrorException()
                    HttpResponseCodes.UNAUTHORIZED -> throw NotAuthorizedException()
                    else -> emptyList()
                }
            } catch (ex: Exception) {
                throw ex
            }
        } else {
            throw InternetNotReachableException()
        }
    }
}