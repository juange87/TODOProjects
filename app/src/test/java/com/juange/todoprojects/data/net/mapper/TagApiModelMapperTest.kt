package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.TagApiModel
import com.juange.todoprojects.domain.model.Tag
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test

class TagApiModelMapperTest {

    private var mapper: TagApiModelMapper? = null

    @Before
    fun setUp() {
        mapper = TagApiModelMapper()
    }

    @After
    fun tearDown() {
        mapper = null
    }

    @Test
    fun testMapObject() {
        val fakeApiTag = createFakeApiTag()
        val mapToDomain = mapper!!.mapToDomain(fakeApiTag)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(FAKE_COLOR, mapToDomain.color)
        Assert.assertEquals(FAKE_NAME, mapToDomain.name)
        Assert.assertEquals(FAKE_ID, mapToDomain.id)
    }

    @Test
    fun testMapNullObject() {
        val mapToDomain = mapper!!.mapToDomain(null)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(Tag(), mapToDomain)
    }

    @Test
    fun testMapList() {
        val fakeApiTagList = createFakeApiTagList()
        val mapToDomain = mapper!!.mapListToDomain(fakeApiTagList)

        Assert.assertNotNull(mapToDomain)
        Assert.assertTrue(mapToDomain.size == 2)
        Assert.assertEquals(FAKE_COLOR, mapToDomain[0].color)
        Assert.assertEquals(FAKE_NAME, mapToDomain[0].name)
        Assert.assertEquals(FAKE_ID, mapToDomain[0].id)
        Assert.assertEquals(FAKE_COLOR_2, mapToDomain[1].color)
        Assert.assertEquals(FAKE_NAME_2, mapToDomain[1].name)
        Assert.assertEquals(FAKE_ID_2, mapToDomain[1].id)
    }

    @Test
    fun testMapNullList() {
        val mapToDomain = mapper!!.mapListToDomain(null)

        Assert.assertNotNull(mapToDomain)
        Assert.assertTrue(mapToDomain.isEmpty())
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