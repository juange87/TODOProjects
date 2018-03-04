package com.juange.todoprojects.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.juange.todoprojects.data.persistence.ProjectStorage
import com.juange.todoprojects.data.persistence.ProjectStorageImpl
import com.juange.todoprojects.data.persistence.room.base.DataBase
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideProjectStorage(storage: ProjectStorageImpl): ProjectStorage = storage

    @Provides
    @Singleton
    @Named(DATABASE)
    fun provideDataBase(context: Context): DataBase {
        return Room.databaseBuilder(context.applicationContext, DataBase::class.java, "project_room").build()
    }

    @Provides
    @Singleton
    fun provideProjectRoomDao(@Named(DATABASE) dataBase: DataBase): ProjectRoomDao {
        return dataBase.projectRoomDao()
    }

    companion object {
        const val DATABASE = "database"
    }
}
