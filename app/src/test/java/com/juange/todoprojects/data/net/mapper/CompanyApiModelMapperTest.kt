package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.CompanyApiModel
import com.juange.todoprojects.domain.model.Company
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test

class CompanyApiModelMapperTest {

    private var mapper: CompanyApiModelMapper? = null

    @Before
    fun setUp() {
        mapper = CompanyApiModelMapper()
    }

    @After
    fun tearDown() {
        mapper = null
    }

    @Test
    fun testMapObject() {
        val fakeCompany = createFakeCompanyApi()
        val mapToDomain = mapper!!.mapToDomain(fakeCompany)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(FAKE_IS_OWNER, mapToDomain.isOwner)
        Assert.assertEquals(FAKE_NAME, mapToDomain.name)
        Assert.assertEquals(FAKE_ID, mapToDomain.id)
    }

    @Test
    fun testMapNullObject() {
        val mapToDomain = mapper!!.mapToDomain(null)

        Assert.assertNotNull(mapToDomain)
        Assert.assertEquals(Company(), mapToDomain)
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