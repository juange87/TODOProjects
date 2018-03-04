package com.juange.todoprojects.data.persistence.room.model

import android.arch.persistence.room.*
import com.juange.todoprojects.domain.model.Project

@Entity(tableName = "project")
data class ProjectRoomEntity(
        @PrimaryKey var id: String = "",
        var replyByEmailEnabled: Boolean = false,
        var endDate: String = "",
        var createdOn: String = "",
        var announcementHTML: String = "",
        var description: String = "",
        var overviewStartPage: String = "",
        var starred: Boolean = false,
        var logo: String = "",
        @Embedded var company: CompanyRoomEntity = CompanyRoomEntity(),
        var announcement: String = "",
        var tasksStartPage: String = "",
        var startPage: String = "",
        var notifyEveryone: Boolean = false,
        var filesAutoNewVersion: Boolean = false,
        var subStatus: String = "",
        var tags: List<TagRoomEntity>? = null,
        var privacyEnabled: Boolean = false,
        var isProjectAdmin: Boolean = false,
        var defaultPrivacy: String = "",
        var lastChangedOn: String = "",
        var name: String = "",
        var showAnnouncement: Boolean = false,
        var harvestTimersEnabled: Boolean = false,
        @Embedded var category: CategoryRoomEntity = CategoryRoomEntity(),
        var startDate: String = "",
        var status: String = ""
)

@Dao
interface ProjectRoomDao {
    @Query("SELECT * FROM project")
    fun getProjects(): List<ProjectRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(project: ProjectRoomEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProjects(projects: List<ProjectRoomEntity>) : List<Long>

    @Query("DELETE FROM project;")
    fun deleteAll()
}

fun ProjectRoomEntity.mapper(): Project {
    return Project(
            replyByEmailEnabled = this.replyByEmailEnabled,
            endDate = this.endDate,
            createdOn = this.createdOn,
            announcementHTML = this.announcementHTML,
            description = this.description,
            overviewStartPage = this.overviewStartPage,
            starred = this.starred,
            logo = this.logo,
            company = this.company.mapper(),
            id = this.id,
            announcement = this.announcement,
            tasksStartPage = this.tasksStartPage,
            startPage = this.startPage,
            notifyEveryone = this.notifyEveryone,
            filesAutoNewVersion = this.filesAutoNewVersion,
            subStatus = this.subStatus,
            tags = this.tags?.mapper(),
            privacyEnabled = this.privacyEnabled,
            isProjectAdmin = this.isProjectAdmin,
            defaultPrivacy = this.defaultPrivacy,
            lastChangedOn = this.lastChangedOn,
            name = this.name,
            showAnnouncement = this.showAnnouncement,
            harvestTimersEnabled = this.harvestTimersEnabled,
            category = this.category.mapper(),
            startDate = this.startDate,
            status = this.status)
}

fun Collection<ProjectRoomEntity>.mapper(): List<Project> = this.map { it.mapper() }

fun Project.mapper(): ProjectRoomEntity {
    return ProjectRoomEntity(
            replyByEmailEnabled = this.replyByEmailEnabled,
            endDate = this.endDate,
            createdOn = this.createdOn,
            announcementHTML = this.announcementHTML,
            description = this.description,
            overviewStartPage = this.overviewStartPage,
            starred = this.starred,
            logo = this.logo,
            company = this.company.mapper(),
            id = this.id,
            announcement = this.announcement,
            tasksStartPage = this.tasksStartPage,
            startPage = this.startPage,
            notifyEveryone = this.notifyEveryone,
            filesAutoNewVersion = this.filesAutoNewVersion,
            subStatus = this.subStatus,
            tags = this.tags?.mapper(),
            privacyEnabled = this.privacyEnabled,
            isProjectAdmin = this.isProjectAdmin,
            defaultPrivacy = this.defaultPrivacy,
            lastChangedOn = this.lastChangedOn,
            name = this.name,
            showAnnouncement = this.showAnnouncement,
            harvestTimersEnabled = this.harvestTimersEnabled,
            category = this.category.mapper(),
            startDate = this.startDate,
            status = this.status)
}

fun List<Project>.mapper(): List<ProjectRoomEntity> = this.map { it.mapper() }
