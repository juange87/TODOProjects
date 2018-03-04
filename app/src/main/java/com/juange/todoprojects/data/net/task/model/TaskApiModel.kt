package com.juange.todoprojects.data.net.task.model

import com.google.gson.annotations.SerializedName
import com.juange.todoprojects.domain.task.Task

data class TaskApiModel(
        @SerializedName("project-name")
        val projectName: String = "",
        @SerializedName("responsible-party-lastname")
        val responsiblePartyLastName: String = "",
        @SerializedName("creator-firstname")
        val creatorFirstName: String = "",
        @SerializedName("timeIsLogged")
        val timeIsLogged: String = "",
        @SerializedName("responsible-party-names")
        val responsiblePartyNames: String = "",
        @SerializedName("responsible-party-summary")
        val responsiblePartySummary: String = "",
        @SerializedName("company-id")
        val companyId: Int = 0,
        @SerializedName("due-date-base")
        val dueDateBase: String = "",
        @SerializedName("creator-lastname")
        val creatorLastName: String = "",
        @SerializedName("userFollowingChanges")
        val userFollowingChanges: Boolean = false,
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("harvest-enabled")
        val harvestEnabled: Boolean = false,
        @SerializedName("order")
        val order: Int = 0,
        @SerializedName("todo-list-name")
        val todoListName: String = "",
        @SerializedName("company-name")
        val companyName: String = "",
        @SerializedName("estimated-minutes")
        val estimatedMinutes: Int = 0,
        @SerializedName("hasTickets")
        val hasTickets: Boolean = false,
        @SerializedName("lockdownId")
        val lockDownId: String = "",
        @SerializedName("comments-count")
        val commentsCount: Int = 0,
        @SerializedName("completed")
        val completed: Boolean = false,
        @SerializedName("priority")
        val priority: String = "",
        @SerializedName("responsible-party-firstname")
        val responsiblePartyFirstName: String = "",
        @SerializedName("last-changed-on")
        val lastChangedOn: String = "",
        @SerializedName("responsible-party-id")
        val responsiblePartyId: String = "",
        @SerializedName("position")
        val position: Int = 0,
        @SerializedName("has-reminders")
        val hasReminders: Boolean = false,
        @SerializedName("status")
        val status: String = "",
        @SerializedName("private")
        val private: Int = 0,
        @SerializedName("userFollowingComments")
        val userFollowingComments: Boolean = false,
        @SerializedName("DLM")
        val dlm: Int = 0,
        @SerializedName("created-on")
        val createdOn: String = "",
        @SerializedName("parentTaskId")
        val parentTaskId: String = "",
        @SerializedName("canEdit")
        val canEdit: Boolean = false,
        @SerializedName("description")
        val description: String = "",
        @SerializedName("start-date")
        val startDate: String = "",
        @SerializedName("has-predecessors")
        val hasPredecessors: Int = 0,
        @SerializedName("responsible-party-type")
        val responsiblePartyType: String = "",
        @SerializedName("content")
        val content: String = "",
        @SerializedName("todo-list-id")
        val todoListId: Int = 0,
        @SerializedName("responsible-party-ids")
        val responsiblePartyIds: String = "",
        @SerializedName("due-date")
        val dueDate: String = "",
        @SerializedName("attachments-count")
        val attachmentsCount: Int = 0,
        @SerializedName("project-id")
        val projectId: Int = 0,
        @SerializedName("tasklist-isTemplate")
        val taskListIsTemplate: Boolean = false,
        @SerializedName("canComplete")
        val canComplete: Boolean = false,
        @SerializedName("creator-id")
        val creatorId: Int = 0,
        @SerializedName("has-dependencies")
        val hasDependencies: Int = 0,
        @SerializedName("canLogTime")
        val canLogTime: Boolean = false,
        @SerializedName("tasklist-private")
        val taskListPrivate: Boolean = false,
        @SerializedName("has-unread-comments")
        val hasUnreadComments: Boolean = false,
        @SerializedName("tasklist-lockdownId")
        val taskListLockDownId: String = "",
        @SerializedName("viewEstimatedTime")
        val viewEstimatedTime: Boolean = false,
        @SerializedName("progress")
        val progress: Int = 0,
        @SerializedName("creator-avatar-url")
        val creatorAvatarUrl: String = "")

fun TaskApiModel.mapToDomain(): Task {
    return Task(
            projectName = this.projectName,
            responsiblePartyLastName = this.responsiblePartyLastName,
            creatorFirstName = this.creatorFirstName,
            timeIsLogged = this.timeIsLogged,
            responsiblePartyNames = this.responsiblePartyNames,
            responsiblePartySummary = this.responsiblePartySummary,
            companyId = this.companyId,
            dueDateBase = this.dueDateBase,
            creatorLastName = this.creatorLastName,
            userFollowingChanges = this.userFollowingChanges,
            id = this.id,
            harvestEnabled = this.harvestEnabled,
            order = this.order,
            todoListName = this.todoListName,
            companyName = this.companyName,
            estimatedMinutes = this.estimatedMinutes,
            hasTickets = this.hasTickets,
            lockDownId = this.lockDownId,
            commentsCount = this.commentsCount,
            completed = this.completed,
            priority = this.priority,
            responsiblePartyFirstName = this.responsiblePartyFirstName,
            lastChangedOn = this.lastChangedOn,
            responsiblePartyId = this.responsiblePartyId,
            position = this.position,
            hasReminders = this.hasReminders,
            status = this.status,
            private = this.private,
            userFollowingComments = this.userFollowingComments,
            dlm = this.dlm,
            createdOn = this.createdOn,
            parentTaskId = this.parentTaskId,
            canEdit = this.canEdit,
            description = this.description,
            startDate = this.startDate,
            hasPredecessors = this.hasPredecessors,
            responsiblePartyType = this.responsiblePartyType,
            content = this.content,
            todoListId = this.todoListId,
            responsiblePartyIds = this.responsiblePartyIds,
            dueDate = this.dueDate,
            attachmentsCount = this.attachmentsCount,
            projectId = this.projectId,
            taskListIsTemplate = this.taskListIsTemplate,
            canComplete = this.canComplete,
            creatorId = this.creatorId,
            hasDependencies = this.hasDependencies,
            canLogTime = this.canLogTime,
            taskListPrivate = this.taskListPrivate,
            hasUnreadComments = this.hasUnreadComments,
            taskListLockDownId = this.taskListLockDownId,
            viewEstimatedTime = this.viewEstimatedTime,
            progress = this.progress,
            creatorAvatarUrl = this.creatorAvatarUrl)
}

fun Collection<TaskApiModel>.mapToDomain(): List<Task> = this.map { it.mapToDomain() }

fun Task.mapToApi(): TaskApiModel {
    return TaskApiModel(
            projectName = this.projectName,
            responsiblePartyLastName = this.responsiblePartyLastName,
            creatorFirstName = this.creatorFirstName,
            timeIsLogged = this.timeIsLogged,
            responsiblePartyNames = this.responsiblePartyNames,
            responsiblePartySummary = this.responsiblePartySummary,
            companyId = this.companyId,
            dueDateBase = this.dueDateBase,
            creatorLastName = this.creatorLastName,
            userFollowingChanges = this.userFollowingChanges,
            id = this.id,
            harvestEnabled = this.harvestEnabled,
            order = this.order,
            todoListName = this.todoListName,
            companyName = this.companyName,
            estimatedMinutes = this.estimatedMinutes,
            hasTickets = this.hasTickets,
            lockDownId = this.lockDownId,
            commentsCount = this.commentsCount,
            completed = this.completed,
            priority = this.priority,
            responsiblePartyFirstName = this.responsiblePartyFirstName,
            lastChangedOn = this.lastChangedOn,
            responsiblePartyId = this.responsiblePartyId,
            position = this.position,
            hasReminders = this.hasReminders,
            status = this.status,
            private = this.private,
            userFollowingComments = this.userFollowingComments,
            dlm = this.dlm,
            createdOn = this.createdOn,
            parentTaskId = this.parentTaskId,
            canEdit = this.canEdit,
            description = this.description,
            startDate = this.startDate,
            hasPredecessors = this.hasPredecessors,
            responsiblePartyType = this.responsiblePartyType,
            content = this.content,
            todoListId = this.todoListId,
            responsiblePartyIds = this.responsiblePartyIds,
            dueDate = this.dueDate,
            attachmentsCount = this.attachmentsCount,
            projectId = this.projectId,
            taskListIsTemplate = this.taskListIsTemplate,
            canComplete = this.canComplete,
            creatorId = this.creatorId,
            hasDependencies = this.hasDependencies,
            canLogTime = this.canLogTime,
            taskListPrivate = this.taskListPrivate,
            hasUnreadComments = this.hasUnreadComments,
            taskListLockDownId = this.taskListLockDownId,
            viewEstimatedTime = this.viewEstimatedTime,
            progress = this.progress,
            creatorAvatarUrl = this.creatorAvatarUrl)
}

fun List<Task>.mapToApi(): List<TaskApiModel> = this.map { it.mapToApi() }
