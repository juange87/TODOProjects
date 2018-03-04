package com.juange.todoprojects.data.net.task.api

import com.juange.todoprojects.data.net.base.BaseApiTest
import com.juange.todoprojects.data.net.base.MockWebServerResponseBuilder
import com.juange.todoprojects.data.net.task.model.TaskApiModel
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

    companion object {
        const val TASKS_RESPONSE: String = "api/Tasks.json"
    }
}