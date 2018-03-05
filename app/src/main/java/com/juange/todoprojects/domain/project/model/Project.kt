package com.juange.todoprojects.domain.project.model

import com.juange.todoprojects.util.formatDateToViewFormat

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

fun Project.startDateFormatted(): String = formatDateToViewFormat(this.startDate)

fun Project.endDateFormatted(): String = formatDateToViewFormat(this.endDate)

fun Project.datePeriodFormatted(): String = "${this.startDateFormatted()} - ${this.endDateFormatted()}"