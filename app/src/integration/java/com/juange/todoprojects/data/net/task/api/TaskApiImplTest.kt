package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.net.base.BaseApiTest
import com.juange.todoprojects.data.net.base.MockWebServerResponseBuilder
import com.juange.todoprojects.exceptions.InternetNotReachableException
import com.juange.todoprojects.exceptions.NotAuthorizedException
import com.juange.todoprojects.exceptions.NotFoundException
import com.juange.todoprojects.exceptions.ServerErrorException
import io.mockk.every
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

        val tasksByProject = api.getTasksByProject(0)
        Assert.assertTrue(tasksByProject.size == 250)
    }

    @Test
    fun testGetTasksEmpty() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder(200).bodyFromFile(EMPTY_RESPONSE).build()
        server.enqueue(response)

        val tasksByProject = api.getTasksByProject(0)
        Assert.assertTrue(tasksByProject.isEmpty())
    }

    @Test(expected = ServerErrorException::class)
    fun testGetTasks500Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode500().build()
        server.enqueue(response)

        api.getTasksByProject(0)
    }

    @Test(expected = NotFoundException::class)
    fun testGetTasks404Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode404().build()
        server.enqueue(response)

        api.getTasksByProject(0)
    }

    @Test(expected = NotAuthorizedException::class)
    fun testGetTasks401Error() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { true }

        val response = MockWebServerResponseBuilder().httpCode401().build()
        server.enqueue(response)

        api.getTasksByProject(0)
    }

    @Test(expected = InternetNotReachableException::class)
    fun testGetTasksNoInternetError() {
        every { netConnectivityManager.internetConnectionAvailable() } answers { false }

        val response = MockWebServerResponseBuilder(200).bodyFromFile(EMPTY_RESPONSE).build()
        server.enqueue(response)

        api.getTasksByProject(0)
    }


    companion object {
        const val TASKS_RESPONSE: String = "api/Tasks.json"
        const val EMPTY_RESPONSE: String = "api/GenericEmptyResponse.json"
    }
}