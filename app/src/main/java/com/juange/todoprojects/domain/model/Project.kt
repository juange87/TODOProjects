package com.juange.todoprojects.domain.model

data class Project(
        val replyByEmailEnabled: Boolean = false,
        val endDate: String = "",
        val createdOn: String = "",
        val announcementHTML: String = "",
        val description: String = "",
        val overviewStartPage: String = "",
        val starred: Boolean = false,
        val logo: String = "",
        val company: Company = Company(),
        val id: String = "",
        val announcement: String = "",
        val tasksStartPage: String = "",
        val startPage: String = "",
        val notifyEveryone: Boolean = false,
        val filesAutoNewVersion: Boolean = false,
        val subStatus: String = "",
        val tags: List<Tag>? = null,
        val privacyEnabled: Boolean = false,
        val isProjectAdmin: Boolean = false,
        val defaultPrivacy: String = "",
        val lastChangedOn: String = "",
        val name: String = "",
        val showAnnouncement: Boolean = false,
        val harvestTimersEnabled: Boolean = false,
        val category: Category = Category(),
        val startDate: String = "",
        val status: String = "")

data class Company(
        val isOwner: String = "",
        val name: String = "",
        val id: String = "")

data class Category(
        val color: String = "",
        val name: String = "",
        val id: String = "")

data class Tag(
        val color: String = "",
        val name: String = "",
        val id: String = "")
