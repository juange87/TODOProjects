package com.juange.todoprojects.data.net.model

import com.google.gson.annotations.SerializedName

data class ProjectApiModelResponse(
        @SerializedName("STATUS") val status: String = "",
        @SerializedName("projects") val projects: List<ProjectApiModel>?)

data class CompanyApiModel(
        @SerializedName("is-owner")
        val isOwner: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")

data class CategoryApiModel(
        @SerializedName("color")
        val color: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")

data class TagApiModel(
        @SerializedName("color")
        val color: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")

data class ProjectApiModel(
        @SerializedName("replyByEmailEnabled")
        val replyByEmailEnabled: Boolean = false,
        @SerializedName("endDate")
        val endDate: String = "",
        @SerializedName("created-on")
        val createdOn: String = "",
        @SerializedName("announcementHTML")
        val announcementHTML: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("overview-start-page")
        val overviewStartPage: String = "",
        @SerializedName("starred")
        val starred: Boolean = false,
        @SerializedName("logo")
        val logo: String = "",
        @SerializedName("company")
        val company: CompanyApiModel,
        @SerializedName("id")
        val id: String = "",
        @SerializedName("announcement")
        val announcement: String = "",
        @SerializedName("tasks-start-page")
        val tasksStartPage: String = "",
        @SerializedName("start-page")
        val startPage: String = "",
        @SerializedName("notifyeveryone")
        val notifyEveryone: Boolean = false,
        @SerializedName("filesAutoNewVersion")
        val filesAutoNewVersion: Boolean = false,
        @SerializedName("subStatus")
        val subStatus: String = "",
        @SerializedName("tags")
        val tags: List<TagApiModel>?,
        @SerializedName("privacyEnabled")
        val privacyEnabled: Boolean = false,
        @SerializedName("isProjectAdmin")
        val isProjectAdmin: Boolean = false,
        @SerializedName("defaultPrivacy")
        val defaultPrivacy: String = "",
        @SerializedName("last-changed-on")
        val lastChangedOn: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("show-announcement")
        val showAnnouncement: Boolean = false,
        @SerializedName("harvest-timers-enabled")
        val harvestTimersEnabled: Boolean = false,
        @SerializedName("category")
        val category: CategoryApiModel,
        @SerializedName("startDate")
        val startDate: String = "",
        @SerializedName("status")
        val status: String = "")
