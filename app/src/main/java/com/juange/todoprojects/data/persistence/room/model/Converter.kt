package com.juange.todoprojects.data.persistence.room.model

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromString(value: String): List<TagRoomEntity>? {
        val listType = object : TypeToken<List<TagRoomEntity>>() {

        }.type
        return Gson().fromJson<List<TagRoomEntity>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<TagRoomEntity>): String {
        return Gson().toJson(list)
    }
}
