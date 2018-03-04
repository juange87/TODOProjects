package com.juange.todoprojects.data.net.model

import com.google.gson.annotations.SerializedName
import com.juange.todoprojects.domain.model.Tag

data class TagApiModel(
        @SerializedName("color")
        val color: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")

fun TagApiModel.mapToDomain(): Tag {
    return Tag(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun Collection<TagApiModel>.mapToDomain(): List<Tag> = this.map { it.mapToDomain() }

fun Tag.mapToApi(): TagApiModel {
    return TagApiModel(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun List<Tag>.mapToApi(): List<TagApiModel> = this.map { it.mapToApi() }
