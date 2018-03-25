package com.juange.todoprojects.data.net.project.api

import com.juange.todoprojects.data.di.ApiModule
import com.juange.todoprojects.data.net.base.NetConnectivityManager
import com.juange.todoprojects.data.net.project.model.ProjectApiModel
import com.juange.todoprojects.data.net.project.model.ProjectApiModelResponse
import com.juange.todoprojects.util.Logger
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class ProjectApiImpl @Inject constructor(
        @Named(ApiModule.PROJECT_SERVICE) private val service: ProjectService,
        private val connectivityManager: NetConnectivityManager
) : ProjectApi {

    override fun getProjects(): List<ProjectApiModel> {
//        if (connectivityManager.internetConnectionAvailable()) {
//            try {
        val call: Call<ProjectApiModelResponse> = service.getProjects()
        val response: Response<ProjectApiModelResponse> = call.execute()

        val headers = response.headers()
        Logger.i("HEADERS: " + headers.toString())

        val responseCode = response.code()
        Logger.i("CODE: $responseCode")

        val success = response.isSuccessful
        Logger.i("SUCCESS: $success")

        val message = response.message()
        Logger.i("MESSAGE: $message")

        return response.body()?.projects ?: emptyList()

//                when (responseCode) {
//                    HttpResponseCodes.OK -> response.body()?.let { it1 ->
//                        it.onSuccess(it1.projects ?: emptyList())
//                    }
//                    HttpResponseCodes.NOT_FOUND -> it.onError(NotFoundException())
//                    HttpResponseCodes.SERVER_ERROR -> it.onError(ServerErrorException())
//                    HttpResponseCodes.UNAUTHORIZED -> it.onError(NotAuthorizedException())
//                }
//            } catch (ex: Exception) {
//                it.onError(ex)
//            }
//        } else {
//            it.onError(InternetNotReachableException())
//        }
    }
}