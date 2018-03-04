package com.juange.todoprojects.data.net.project.api

import com.juange.todoprojects.data.net.base.BaseApiTest
import com.juange.todoprojects.data.net.base.MockWebServerResponseBuilder
import com.juange.todoprojects.data.net.project.model.ProjectApiModel
import io.mockk.every
import io.reactivex.observers.TestObserver
import junit.framework.Assert
import org.junit.Test

class ProjectApiImplTest : BaseApiTest() {

    private lateinit var api: ProjectApiImpl

    override fun onInit() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val service = createRetrofitClient().create(ProjectService::class.java)
        api = ProjectApiImpl(service, netConnectivityManager)
    }

    @Test
    fun testGetProjects() {
        val response = MockWebServerResponseBuilder(200).bodyFromFile(PROJECTS_RESPONSE).build()
        server.enqueue(response)

        val testObserver = TestObserver<List<ProjectApiModel>>()
        api.getProjects()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertValue({
            Assert.assertTrue(it.size == 2)
            true
        })
    }

    companion object {
        const val PROJECTS_RESPONSE: String = "api/Projects.json"
    }
}