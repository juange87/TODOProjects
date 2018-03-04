package com.juange.todoprojects.data.net.model

import com.google.gson.annotations.SerializedName
import com.juange.todoprojects.domain.model.Company

data class CompanyApiModel(
        @SerializedName("is-owner")
        val isOwner: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")

fun CompanyApiModel.mapToDomain(): Company {
        return Company(
                isOwner = this.isOwner,
                name = this.name,
                id = this.id
        )
}

fun Collection<CompanyApiModel>.mapToDomain(): List<Company> = this.map { it.mapToDomain() }

fun Company.mapToApi(): CompanyApiModel {
        return CompanyApiModel(
                isOwner = this.isOwner,
                name = this.name,
                id = this.id
        )
}

fun List<Company>.mapToApi(): List<CompanyApiModel> = this.map { it.mapToApi() }
