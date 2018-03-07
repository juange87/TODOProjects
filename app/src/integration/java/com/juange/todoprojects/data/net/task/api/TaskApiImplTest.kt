package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.net.base.BaseApiTest
import com.juange.todoprojects.data.net.base.MockWebServerResponseBuilder
import com.juange.todoprojects.data.net.task.model.TaskApiModel
import com.juange.todoprojects.exceptions.InternetNotReachableException
import com.juange.todoprojects.exceptions.NotAuthorizedException
import com.juange.todoprojects.exceptions.NotFoundException
import com.juange.todoprojects.exceptions.ServerErrorException
import io.mockk.every
import io.reactivex.observers.TestObserver
import junit.framework.Assert
import org.junit.Test

class TaskApiTest : BaseApiTest() {

    private lateinit var api: TaskApiImpl

    override fun onInit() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val service = createRetrofitClient().create(TaskService::class.java)
        api = TaskApiImpl(service, netConnectivityManager)
    }

    @Test
    fun testGetTasks() {
        val response = MockWebServerResponseBuilder(200).bodyFromFile(TASKS_RESPONSE).build()
        server.enqueue(response)

        val testObserver = TestObserver<List<TaskApiModel>>()
        api.getTasksByProject(0)
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertValue({
            Assert.assertTrue(it.size == 250)
            true
        })
    }

    @Test
    fun testGetTasksEmpty() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder(200).bodyFromFile(EMPTY_RESPONSE).build()
        server.enqueue(response)

        val testObserver = TestObserver<List<TaskApiModel>>()
        api.getTasksByProject(0)
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        testObserver.assertValue({
            Assert.assertTrue(it.isEmpty())
            true
        })
    }

    @Test
    fun testGetTasks500Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode500().build()
        server.enqueue(response)

        val testObserver = TestObserver<List<TaskApiModel>>()
        api.getTasksByProject(0)
                .subscribe(testObserver)

        testObserver.assertError { it is ServerErrorException }
    }

    @Test
    fun testGetTasks404Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode404().build()
        server.enqueue(response)

        val testObserver = TestObserver<List<TaskApiModel>>()
        api.getTasksByProject(0)
                .subscribe(testObserver)

        testObserver.assertError { it is NotFoundException }
    }

    @Test
    fun testGetTasks401Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode401().build()
        server.enqueue(response)

        val testObserver = TestObserver<List<TaskApiModel>>()
        api.getTasksByProject(0)
                .subscribe(testObserver)

        testObserver.assertError { it is NotAuthorizedException }
    }

    @Test
    fun testGetTasksNoInternetError() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { false }

        val response = MockWebServerResponseBuilder(200).bodyFromFile(EMPTY_RESPONSE).build()
        server.enqueue(response)

        val testObserver = TestObserver<List<TaskApiModel>>()
        api.getTasksByProject(0)
                .subscribe(testObserver)

        testObserver.assertError { it is InternetNotReachableException }
    }


    companion object {
        const val TASKS_RESPONSE: String = "api/Tasks.json"
        const val EMPTY_RESPONSE: String = "api/GenericEmptyResponse.json"
    }
}