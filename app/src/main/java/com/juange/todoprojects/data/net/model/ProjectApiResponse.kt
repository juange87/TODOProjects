package com.juange.todoprojects.data.net.model

import com.google.gson.annotations.SerializedName

data class ProjectApiModel(
        @SerializedName("STATUS") val status: String = "",
        @SerializedName("projects") val projects: List<ProjectsItem>?)

data class Company(
        @SerializedName("is-owner")
        val isOwner: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")


data class Integrations(
        @SerializedName("onedrivebusiness")
        val onedrivebusiness: Onedrivebusiness,
        @SerializedName("microsoftConnectors")
        val microsoftConnectors: MicrosoftConnectors)


data class Defaults(
        @SerializedName("privacy") val privacy: String = "")


data class Category(
        @SerializedName("color")
        val color: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")


data class TagsItem(
        @SerializedName("color")
        val color: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("id")
        val id: String = "")


data class Onedrivebusiness(
        @SerializedName("folder")
        val folder: String = "",
        @SerializedName("foldername")
        val foldername: String = "",
        @SerializedName("enabled")
        val enabled: Boolean = false,
        @SerializedName("account")
        val account: String = "")


data class MicrosoftConnectors(
        @SerializedName("enabled")
        val enabled: Boolean = false)


data class ProjectsItem(
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
        val company: Company,
        @SerializedName("id")
        val id: String = "",
        @SerializedName("announcement")
        val announcement: String = "",
        @SerializedName("tasks-start-page")
        val tasksStartPage: String = "",
        @SerializedName("start-page")
        val startPage: String = "",
        @SerializedName("notifyeveryone")
        val notifyeveryone: Boolean = false,
        @SerializedName("filesAutoNewVersion")
        val filesAutoNewVersion: Boolean = false,
        @SerializedName("subStatus")
        val subStatus: String = "",
        @SerializedName("tags")
        val tags: List<TagsItem>?,
        @SerializedName("privacyEnabled")
        val privacyEnabled: Boolean = false,
        @SerializedName("isProjectAdmin")
        val isProjectAdmin: Boolean = false,
        @SerializedName("defaultPrivacy")
        val defaultPrivacy: String = "",
        @SerializedName("last-changed-on")
        val lastChangedOn: String = "",
        @SerializedName("defaults")
        val defaults: Defaults,
        @SerializedName("name")
        val name: String = "",
        @SerializedName("show-announcement")
        val showAnnouncement: Boolean = false,
        @SerializedName("harvest-timers-enabled")
        val harvestTimersEnabled: Boolean = false,
        @SerializedName("category")
        val category: Category,
        @SerializedName("integrations")
        val integrations: Integrations,
        @SerializedName("startDate")
        val startDate: String = "",
        @SerializedName("status")
        val status: String = "")
