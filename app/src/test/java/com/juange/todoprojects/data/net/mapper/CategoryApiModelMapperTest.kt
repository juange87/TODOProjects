package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.CategoryApiModel
import com.juange.todoprojects.data.net.model.mapToDomain
import junit.framework.Assert
import org.junit.Test

class CategoryApiModelMapperTest {

    @Test
    fun testMapObject() {
        val fakeCategory = createFakeCategoryApi()
        val mapToDomain = fakeCategory.mapToDomain()

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(FAKE_COLOR, mapToDomain.color)
        Assert.assertEquals(FAKE_NAME, mapToDomain.name)
        Assert.assertEquals(FAKE_ID, mapToDomain.id)
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