package com.juange.todoprojects.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.juange.todoprojects.data.persistence.base.DataBase
import com.juange.todoprojects.data.persistence.project.ProjectStorage
import com.juange.todoprojects.data.persistence.project.ProjectStorageImpl
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import com.juange.todoprojects.data.persistence.task.TaskStorage
import com.juange.todoprojects.data.persistence.task.TaskStorageImpl
import com.juange.todoprojects.data.persistence.task.model.TaskRoomDao
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    @Named(DATABASE)
    fun provideDataBase(context: Context): DataBase =
            Room.databaseBuilder(context.applicationContext, DataBase::class.java, "project_room").build()

    @Provides
    @Singleton
    fun provideProjectStorage(storage: ProjectStorageImpl): ProjectStorage = storage

    @Provides
    @Singleton
    fun provideTaskStorage(storage: TaskStorageImpl): TaskStorage = storage

    @Provides
    @Singleton
    fun provideProjectRoomDao(@Named(DATABASE) dataBase: DataBase): ProjectRoomDao = dataBase.projectRoomDao()

    @Provides
    @Singleton
    fun provideTaskRoomDao(@Named(DATABASE) dataBase: DataBase): TaskRoomDao = dataBase.taskRoomDao()

    companion object {
        const val DATABASE = "database"
    }
}
