package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.project.model.TagApiModel
import com.juange.todoprojects.data.net.project.model.mapToDomain
import junit.framework.Assert
import org.junit.Test

class TagApiModelMapperTest {

    @Test
    fun testMapObject() {
        val fakeApiTag = createFakeApiTag()
        val mapToDomain = fakeApiTag.mapToDomain()

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(FAKE_COLOR, mapToDomain.color)
        Assert.assertEquals(FAKE_NAME, mapToDomain.name)
        Assert.assertEquals(FAKE_ID, mapToDomain.id)
    }

    @Test
    fun testMapList() {
        val fakeApiTagList = createFakeApiTagList()
        val mapToDomain = fakeApiTagList.mapToDomain()

        Assert.assertNotNull(mapToDomain)
        Assert.assertTrue(mapToDomain.size == 2)
        Assert.assertEquals(FAKE_COLOR, mapToDomain[0].color)
        Assert.assertEquals(FAKE_NAME, mapToDomain[0].name)
        Assert.assertEquals(FAKE_ID, mapToDomain[0].id)
        Assert.assertEquals(FAKE_COLOR_2, mapToDomain[1].color)
        Assert.assertEquals(FAKE_NAME_2, mapToDomain[1].name)
        Assert.assertEquals(FAKE_ID_2, mapToDomain[1].id)
    }

    private fun createFakeApiTag(): TagApiModel {
        return TagApiModel(
                color = FAKE_COLOR,
                name = FAKE_NAME,
                id = FAKE_ID
        )
    }

    private fun createFakeApiTagList(): List<TagApiModel> {
        return listOf(createFakeApiTag(), TagApiModel(FAKE_COLOR_2, FAKE_NAME_2, FAKE_ID_2))
    }

    companion object {
        const val FAKE_COLOR: String = "red"
        const val FAKE_NAME: String = "Critical"
        const val FAKE_ID: String = "123456"

        const val FAKE_COLOR_2: String = "blue"
        const val FAKE_NAME_2: String = "Debug"
        const val FAKE_ID_2: String = "1234"
    }
}