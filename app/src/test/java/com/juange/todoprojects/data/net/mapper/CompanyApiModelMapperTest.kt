package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.CompanyApiModel
import com.juange.todoprojects.data.net.model.mapToDomain
import junit.framework.Assert
import org.junit.Test

class CompanyApiModelMapperTest {

    @Test
    fun testMapObject() {
        val fakeCompany = createFakeCompanyApi()
        val mapToDomain = fakeCompany.mapToDomain()

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(FAKE_IS_OWNER, mapToDomain.isOwner)
        Assert.assertEquals(FAKE_NAME, mapToDomain.name)
        Assert.assertEquals(FAKE_ID, mapToDomain.id)
    }

    private fun createFakeCompanyApi(): CompanyApiModel {
        return CompanyApiModel(
                isOwner = FAKE_IS_OWNER,
                name = FAKE_NAME,
                id = FAKE_ID
        )
    }

    companion object {
        const val FAKE_IS_OWNER: String = "1"
        const val FAKE_NAME: String = "Greatest One"
        const val FAKE_ID: String = "0987"
    }
}