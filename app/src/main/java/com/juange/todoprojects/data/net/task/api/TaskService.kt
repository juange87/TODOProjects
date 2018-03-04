package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.net.task.model.TaskApiModelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TaskService {

    @GET("projects/{project_id}/tasks.json")
    fun getTasksByProject(@Path("project_id") project_id: String): Call<TaskApiModelResponse>
}