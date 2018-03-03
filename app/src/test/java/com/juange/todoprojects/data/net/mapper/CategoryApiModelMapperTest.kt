package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.CategoryApiModel
import com.juange.todoprojects.domain.model.Category
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test

class CategoryApiModelMapperTest {
    private var mapper: CategoryApiModelMapper? = null

    @Before
    fun setUp() {
        mapper = CategoryApiModelMapper()
    }

    @After
    fun tearDown() {
        mapper = null
    }

    @Test
    fun testMapObject() {
        val fakeCategory = createFakeCategoryApi()
        val mapToDomain = mapper!!.mapToDomain(fakeCategory)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(FAKE_COLOR, mapToDomain.color)
        Assert.assertEquals(FAKE_NAME, mapToDomain.name)
        Assert.assertEquals(FAKE_ID, mapToDomain.id)
    }

    @Test
    fun testMapNullObject() {
        val mapToDomain = mapper!!.mapToDomain(null)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(Category(), mapToDomain)
    }

    private fun createFakeCategoryApi(): CategoryApiModel {
        return CategoryApiModel(
                color = FAKE_COLOR,
                name = FAKE_NAME,
                id = FAKE_ID
        )
    }

    companion object {
        const val FAKE_COLOR: String = "red"
        const val FAKE_NAME: String = "Critical"
        const val FAKE_ID: String = "123456"
    }
}