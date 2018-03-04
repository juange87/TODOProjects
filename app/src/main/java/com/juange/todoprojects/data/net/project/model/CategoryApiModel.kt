package com.juange.todoprojects.data.net.project.model

import com.google.gson.annotations.SerializedName
import com.juange.todoprojects.domain.project.model.Category

data class CategoryApiModel(
        @SerializedName("color")
        val color: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")


fun CategoryApiModel.mapToDomain(): Category {
    return Category(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun Collection<CategoryApiModel>.mapToDomain(): List<Category> = this.map { it.mapToDomain() }

fun Category.mapToApi(): CategoryApiModel {
    return CategoryApiModel(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun List<Category>.mapToEntity(): List<CategoryApiModel> = this.map { it.mapToApi() }
