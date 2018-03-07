package com.juange.todoprojects.data.net.task.model

import com.google.gson.annotations.SerializedName

data class TaskApiModelResponse(
        @SerializedName("STATUS") val status: String = "",
        @SerializedName("todo-items") val tasks: List<TaskApiModel>?
)