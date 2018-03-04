package com.juange.todoprojects.data.net.model

import com.google.gson.annotations.SerializedName

data class ProjectApiModelResponse(
        @SerializedName("STATUS") val status: String = "",
        @SerializedName("projects") val projects: List<ProjectApiModel>?)

