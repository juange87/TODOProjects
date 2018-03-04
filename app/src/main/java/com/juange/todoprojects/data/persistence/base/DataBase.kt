package com.juange.todoprojects.data.persistence.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.juange.todoprojects.data.persistence.room.model.Converter
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomDao
import com.juange.todoprojects.data.persistence.room.model.ProjectRoomEntity

@Database(entities = arrayOf(ProjectRoomEntity::class), version = 1)
@TypeConverters(Converter::class)
abstract class DataBase : RoomDatabase() {
    abstract fun projectRoomDao(): ProjectRoomDao
}
