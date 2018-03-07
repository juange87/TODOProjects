package com.juange.todoprojects.domain.task.model

import junit.framework.Assert
import org.junit.Test

class TaskTest {

    @Test
    fun testFueDateFormatted() {
        val fakeTask = Task(dueDate = "20180309")
        val dueDateFormatted = fakeTask.dueDateFormatted()
        Assert.assertEquals("09/03/2018", dueDateFormatted)
    }
}