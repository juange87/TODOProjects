package com.juange.todoprojects.data.net

import com.juange.todoprojects.data.net.model.ProjectApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ProjectService {

    @GET("projects.json")
    fun getProjects(): Call<ProjectApiModel>
}