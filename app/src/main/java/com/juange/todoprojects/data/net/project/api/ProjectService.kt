package com.juange.todoprojects.data.net.project.api

import com.juange.todoprojects.data.net.project.model.ProjectApiModelResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProjectService {

    @GET("projects.json")
    fun getProjects(): Call<ProjectApiModelResponse>
}