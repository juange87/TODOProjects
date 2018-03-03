package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.ProjectApiModel
import com.juange.todoprojects.domain.model.Project
import javax.inject.Inject

class ProjectApiModelMapper @Inject constructor(
        private val companyApiModelMapper: CompanyApiModelMapper,
        private val tagApiModelMapper: TagApiModelMapper,
        private val categoryApiModelMapper: CategoryApiModelMapper) {

    fun mapToDomain(projectApiModel: ProjectApiModel?): Project {
        return projectApiModel?.let {
            Project(
                    replyByEmailEnabled = it.replyByEmailEnabled,
                    endDate = it.endDate,
                    createdOn = it.createdOn,
                    announcementHTML = it.announcementHTML,
                    description = it.description,
                    overviewStartPage = it.overviewStartPage,
                    starred = it.starred,
                    logo = it.logo,
                    company = companyApiModelMapper.mapToDomain(it.company),
                    id = it.id,
                    announcement = it.announcement,
                    tasksStartPage = it.tasksStartPage,
                    startPage = it.startPage,
                    notifyEveryone = it.notifyEveryone,
                    filesAutoNewVersion = it.filesAutoNewVersion,
                    subStatus = it.subStatus,
                    tags = tagApiModelMapper.mapListToDomain(it.tags),
                    privacyEnabled = it.privacyEnabled,
                    isProjectAdmin = it.isProjectAdmin,
                    defaultPrivacy = it.defaultPrivacy,
                    lastChangedOn = it.lastChangedOn,
                    name = it.name,
                    showAnnouncement = it.showAnnouncement,
                    harvestTimersEnabled = it.harvestTimersEnabled,
                    category = categoryApiModelMapper.mapToDomain(it.category),
                    startDate = it.startDate,
                    status = it.status)
        } ?: Project()
    }

    fun mapListToDomain(list: List<ProjectApiModel>?): List<Project> {
        return list?.map { mapToDomain(it) } ?: emptyList()
    }
}