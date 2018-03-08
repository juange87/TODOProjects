package com.juange.todoprojects.data.persistence.base

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import com.juange.todoprojects.data.persistence.room.model.mapToEntity
import com.juange.todoprojects.data.persistence.task.model.TaskRoomDao
import com.juange.todoprojects.data.persistence.task.model.mapToEntity
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.model.Tag
import com.juange.todoprojects.domain.task.model.Task
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DataBaseTest {

    private lateinit var db: DataBase
    private lateinit var projectDao: ProjectRoomDao
    private lateinit var taskDao: TaskRoomDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(context, DataBase::class.java).build()
        projectDao = db.projectRoomDao()
        taskDao = db.taskRoomDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun testInsertProjectAndReadIt() {
        val projectEntity = Project(id = "projectID", tags = listOf(Tag())).mapToEntity()
        projectDao.insertProject(projectEntity)

        val projectInserted = projectDao.getProjects()

        assertThat(projectInserted[0], equalTo(projectEntity))
    }

    @Test
    @Throws(Exception::class)
    fun testInsertTaskAndReadIt() {
        val projectEntity = Project(id = "1", tags = listOf(Tag())).mapToEntity()
        projectDao.insertProject(projectEntity)

        val taskEntity = Task(id = 12345, projectId = 1).mapToEntity()
        taskDao.insertTask(taskEntity)

        val tasksInserted = taskDao.getTasksByProject(1)

        assertThat(tasksInserted[0], equalTo(taskEntity))
    }
}