package com.juange.todoprojects.data.net.api

import com.juange.todoprojects.data.net.model.ProjectApiModelResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProjectService {

    @GET("projects.json")
    fun getProjects(): Call<ProjectApiModelResponse>
}