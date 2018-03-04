package com.juange.todoprojects.data.net.project.model

import com.google.gson.annotations.SerializedName
import com.juange.todoprojects.domain.project.model.Project

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


fun ProjectApiModel.mapToDomain(): Project {
    return Project(
            replyByEmailEnabled = this.replyByEmailEnabled,
            endDate = this.endDate,
            createdOn = this.createdOn,
            announcementHTML = this.announcementHTML,
            description = this.description,
            overviewStartPage = this.overviewStartPage,
            starred = this.starred,
            logo = this.logo,
            company = this.company.mapToDomain(),
            id = this.id,
            announcement = this.announcement,
            tasksStartPage = this.tasksStartPage,
            startPage = this.startPage,
            notifyEveryone = this.notifyEveryone,
            filesAutoNewVersion = this.filesAutoNewVersion,
            subStatus = this.subStatus,
            tags = this.tags?.mapToDomain(),
            privacyEnabled = this.privacyEnabled,
            isProjectAdmin = this.isProjectAdmin,
            defaultPrivacy = this.defaultPrivacy,
            lastChangedOn = this.lastChangedOn,
            name = this.name,
            showAnnouncement = this.showAnnouncement,
            harvestTimersEnabled = this.harvestTimersEnabled,
            category = this.category.mapToDomain(),
            startDate = this.startDate,
            status = this.status)
}

fun Collection<ProjectApiModel>.mapToDomain(): List<Project> = this.map { it.mapToDomain() }

fun Project.mapToApi(): ProjectApiModel {
    return ProjectApiModel(
            replyByEmailEnabled = this.replyByEmailEnabled,
            endDate = this.endDate,
            createdOn = this.createdOn,
            announcementHTML = this.announcementHTML,
            description = this.description,
            overviewStartPage = this.overviewStartPage,
            starred = this.starred,
            logo = this.logo,
            company = this.company.mapToApi(),
            id = this.id,
            announcement = this.announcement,
            tasksStartPage = this.tasksStartPage,
            startPage = this.startPage,
            notifyEveryone = this.notifyEveryone,
            filesAutoNewVersion = this.filesAutoNewVersion,
            subStatus = this.subStatus,
            tags = this.tags?.mapToApi(),
            privacyEnabled = this.privacyEnabled,
            isProjectAdmin = this.isProjectAdmin,
            defaultPrivacy = this.defaultPrivacy,
            lastChangedOn = this.lastChangedOn,
            name = this.name,
            showAnnouncement = this.showAnnouncement,
            harvestTimersEnabled = this.harvestTimersEnabled,
            category = this.category.mapToApi(),
            startDate = this.startDate,
            status = this.status)
}

fun List<Project>.mapToApi(): List<ProjectApiModel> = this.map { it.mapToApi() }
