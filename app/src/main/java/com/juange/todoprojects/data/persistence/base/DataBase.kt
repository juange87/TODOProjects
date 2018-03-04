package com.juange.todoprojects.data.persistence.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.juange.todoprojects.data.persistence.room.model.Converter
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity
import com.juange.todoprojects.data.persistence.task.model.TaskRoomDao
import com.juange.todoprojects.data.persistence.task.model.TaskRoomEntity

@Database(entities = arrayOf(ProjectRoomEntity::class, TaskRoomEntity::class), version = 1)
@TypeConverters(Converter::class)
abstract class DataBase : RoomDatabase() {
    abstract fun projectRoomDao(): ProjectRoomDao
    abstract fun taskRoomDao(): TaskRoomDao
}
