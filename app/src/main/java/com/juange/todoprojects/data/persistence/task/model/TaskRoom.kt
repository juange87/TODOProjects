package com.juange.todoprojects.data.persistence.task.model

import android.arch.persistence.room.*
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import com.juange.todoprojects.domain.task.model.Task

@Entity(tableName = "task", foreignKeys = arrayOf(ForeignKey(entity = ProjectRoomEntity::class, parentColumns = arrayOf("id"), childColumns = arrayOf("project_id"), onDelete = ForeignKey.CASCADE)))
data class TaskRoomEntity(
        @PrimaryKey var id: Int = 0,
        @ColumnInfo(name = "project_id") var projectId: Int = 0,
        var projectName: String = "",
        var responsiblePartyLastName: String = "",
        var creatorFirstName: String = "",
        var timeIsLogged: String = "",
        var responsiblePartyNames: String = "",
        var responsiblePartySummary: String = "",
        var companyId: Int = 0,
        var dueDateBase: String = "",
        var creatorLastName: String = "",
        var userFollowingChanges: Boolean = false,
        var harvestEnabled: Boolean = false,
        var order: Int = 0,
        var todoListName: String = "",
        var companyName: String = "",
        var estimatedMinutes: Int = 0,
        var hasTickets: Boolean = false,
        var lockDownId: String = "",
        var commentsCount: Int = 0,
        var completed: Boolean = false,
        var priority: String = "",
        var responsiblePartyFirstName: String = "",
        var lastChangedOn: String = "",
        var responsiblePartyId: String = "",
        var position: Int = 0,
        var hasReminders: Boolean = false,
        var status: String = "",
        var private: Int = 0,
        var userFollowingComments: Boolean = false,
        var dlm: Int = 0,
        var createdOn: String = "",
        var parentTaskId: String = "",
        var canEdit: Boolean = false,
        var description: String = "",
        var startDate: String = "",
        var hasPredecessors: Int = 0,
        var responsiblePartyType: String = "",
        var content: String = "",
        var todoListId: Int = 0,
        var responsiblePartyIds: String = "",
        var dueDate: String = "",
        var attachmentsCount: Int = 0,
        var taskListIsTemplate: Boolean = false,
        var canComplete: Boolean = false,
        var creatorId: Int = 0,
        var hasDependencies: Int = 0,
        var canLogTime: Boolean = false,
        var taskListPrivate: Boolean = false,
        var hasUnreadComments: Boolean = false,
        var taskListLockDownId: String = "",
        var viewEstimatedTime: Boolean = false,
        var progress: Int = 0,
        var creatorAvatarUrl: String = "")

@Dao
interface TaskRoomDao {
    @Query("SELECT * FROM task")
    fun getTasks(): List<TaskRoomEntity>

    @Query("SELECT * FROM task WHERE project_id = :projectId")
    fun getTasksByProject(projectId: Int): List<TaskRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: TaskRoomEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTasks(tasks: List<TaskRoomEntity>): List<Long>

    @Query("DELETE FROM task;")
    fun deleteAll()
}

fun TaskRoomEntity.mapToDomain(): Task {
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

fun Collection<TaskRoomEntity>.mapToDomain(): List<Task> = this.map { it.mapToDomain() }

fun Task.mapToEntity(): TaskRoomEntity {
    return TaskRoomEntity(
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

fun List<Task>.maptToEntity(): List<TaskRoomEntity> = this.map { it.mapToEntity() }
