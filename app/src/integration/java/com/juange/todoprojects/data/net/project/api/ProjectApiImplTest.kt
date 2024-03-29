package com.juange.todoprojects.data.net.project.api

import com.juange.todoprojects.data.net.base.BaseApiTest
import com.juange.todoprojects.data.net.base.MockWebServerResponseBuilder
import com.juange.todoprojects.data.net.project.model.ProjectApiModel
import com.juange.todoprojects.exceptions.InternetNotReachableException
import com.juange.todoprojects.exceptions.NotAuthorizedException
import com.juange.todoprojects.exceptions.NotFoundException
import com.juange.todoprojects.exceptions.ServerErrorException
import io.mockk.every
import io.reactivex.observers.TestObserver
import junit.framework.Assert
import org.junit.Test

class ProjectApiImplTest : BaseApiTest() {

    private lateinit var api: ProjectApiImpl

    override fun onInit() {
        val service = createRetrofitClient().create(ProjectService::class.java)
        api = ProjectApiImpl(service, netConnectivityManager)
    }

    @Test
    fun testGetProjects() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

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

    @Test
    fun testGetProjectsEmpty() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder(200).bodyFromFile(EMPTY_RESPONSE).build()
        server.enqueue(response)

        val testObserver = TestObserver<List<ProjectApiModel>>()
        api.getProjects()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertValue({
            Assert.assertTrue(it.isEmpty())
            true
        })
    }

    @Test
    fun testGetProjects500Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode500().build()
        server.enqueue(response)

        val testObserver = TestObserver<List<ProjectApiModel>>()
        api.getProjects()
                .subscribe(testObserver)

        testObserver.assertError { it is ServerErrorException }
    }

    @Test
    fun testGetProjects404Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode404().build()
        server.enqueue(response)

        val testObserver = TestObserver<List<ProjectApiModel>>()
        api.getProjects()
                .subscribe(testObserver)

        testObserver.assertError { it is NotFoundException }
    }

    @Test
    fun testGetProjects401Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode401().build()
        server.enqueue(response)

        val testObserver = TestObserver<List<ProjectApiModel>>()
        api.getProjects()
                .subscribe(testObserver)

        testObserver.assertError { it is NotAuthorizedException }
    }

    @Test
    fun testGetProjectsNoInternetError() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { false }

        val response = MockWebServerResponseBuilder(200).bodyFromFile(EMPTY_RESPONSE).build()
        server.enqueue(response)

        val testObserver = TestObserver<List<ProjectApiModel>>()
        api.getProjects()
                .subscribe(testObserver)

        testObserver.assertError { it is InternetNotReachableException }
    }

    companion object {
        const val PROJECTS_RESPONSE: String = "api/Projects.json"
        const val EMPTY_RESPONSE: String = "api/GenericEmptyResponse.json"
    }
}