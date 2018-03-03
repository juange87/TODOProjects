package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.mapper.TagApiModelMapperTest.Companion.FAKE_COLOR_2
import com.juange.todoprojects.data.net.mapper.TagApiModelMapperTest.Companion.FAKE_ID_2
import com.juange.todoprojects.data.net.mapper.TagApiModelMapperTest.Companion.FAKE_NAME_2
import com.juange.todoprojects.data.net.model.CategoryApiModel
import com.juange.todoprojects.data.net.model.CompanyApiModel
import com.juange.todoprojects.data.net.model.ProjectApiModel
import com.juange.todoprojects.data.net.model.TagApiModel
import com.juange.todoprojects.domain.model.Project
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test

class ProjectApiModelMapperTest {

    private var mapper: ProjectApiModelMapper? = null

    @Before
    fun setUp() {
        mapper = ProjectApiModelMapper(CompanyApiModelMapper(), TagApiModelMapper(), CategoryApiModelMapper())
    }

    @After
    fun tearDown() {
        mapper = null
    }

    @Test
    fun testMapObject() {
        val fakeProject = createFakeProject()
        val mapToDomain = mapper!!.mapToDomain(fakeProject)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals("339988", mapToDomain.id)
        Assert.assertEquals("Adamantium", mapToDomain.name)
    }

    @Test
    fun testMapNullObject() {
        val mapToDomain = mapper!!.mapToDomain(null)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(Project(), mapToDomain)
    }

    @Test
    fun testMapList() {
        val fakeProjects = createFakeProjectList()
        val mapToDomain = mapper!!.mapListToDomain(fakeProjects)

        Assert.assertNotNull(mapToDomain)
        Assert.assertTrue(mapToDomain.size == 4)
    }

    private fun createFakeProjectList(): List<ProjectApiModel> {
        return listOf(createFakeProject(), createFakeProject(), createFakeProject(), createFakeProject())
    }

    @Test
    fun testMapNullList() {
        val mapToDomain = mapper!!.mapListToDomain(null)

        Assert.assertNotNull(mapToDomain)
        Assert.assertTrue(mapToDomain.isEmpty())
    }

    private fun createFakeProject(): ProjectApiModel {
        return ProjectApiModel(
                replyByEmailEnabled = true,
                endDate = "20261025",
                createdOn = "2017-01-03T21:49:20Z",
                announcementHTML = "",
                description = "Adamantium is a fictional metal alloy appearing in American comic books published by Marvel Comics. It is best known as the substance bonded to the character Wolverine's skeleton and claws. Adamantium was created by writer Roy Thomas and artists Barry Windsor-Smith and Syd Shores in Marvel Comics' Avengers #66 (July 1969), which presents the substance as part of the character Ultron's outer shell. In the stories where it appears, the defining quality of adamantium is its practical indestructibilityilitty",
                overviewStartPage = "default",
                starred = false,
                logo = "https://s3.amazonaws.com/TWFiles/349705/projectLogo/tf_49AEF502-ED21-1A9D-87FAE9BD9D485267.dota22.jpg",
                company = createFakeCompanyApi(),
                id = "339988",
                announcement = "",
                tasksStartPage = "default",
                startPage = "projectoverview",
                notifyEveryone = false,
                filesAutoNewVersion = false,
                subStatus = "current",
                tags = createFakeApiTagList(),
                privacyEnabled = false,
                isProjectAdmin = true,
                defaultPrivacy = "open",
                lastChangedOn = "2018-03-01T20:39:23Z",
                name = "Adamantium",
                showAnnouncement = false,
                harvestTimersEnabled = false,
                category = createFakeCategoryApi(),
                startDate = "20140408",
                status = "active")
    }

    private fun createFakeApiTag(): TagApiModel {
        return TagApiModel(
                color = TagApiModelMapperTest.FAKE_COLOR,
                name = TagApiModelMapperTest.FAKE_NAME,
                id = TagApiModelMapperTest.FAKE_ID
        )
    }

    private fun createFakeApiTagList(): List<TagApiModel> {
        return listOf(createFakeApiTag(), TagApiModel(FAKE_COLOR_2, FAKE_NAME_2, FAKE_ID_2))
    }

    private fun createFakeCompanyApi(): CompanyApiModel {
        return CompanyApiModel(
                isOwner = CompanyApiModelMapperTest.FAKE_IS_OWNER,
                name = CompanyApiModelMapperTest.FAKE_NAME,
                id = CompanyApiModelMapperTest.FAKE_ID
        )
    }

    private fun createFakeCategoryApi(): CategoryApiModel {
        return CategoryApiModel(
                color = CategoryApiModelMapperTest.FAKE_COLOR,
                name = CategoryApiModelMapperTest.FAKE_NAME,
                id = CategoryApiModelMapperTest.FAKE_ID
        )
    }
}