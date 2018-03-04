package com.juange.todoprojects.data.persistence.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.juange.todoprojects.domain.model.Category

@Entity(tableName = "category")
data class CategoryRoomEntity(
        @PrimaryKey @ColumnInfo(name = "category_id") var id: String = "",
        @ColumnInfo(name = "category_color") var color: String = "",
        @ColumnInfo(name = "category_name") var name: String = ""
)

fun CategoryRoomEntity.mapper(): Category {
    return Category(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun Collection<CategoryRoomEntity>.mapper(): List<Category> = this.map { it.mapper() }

fun Category.mapper(): CategoryRoomEntity {
    return CategoryRoomEntity(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun List<Category>.mapper(): List<CategoryRoomEntity> = this.map { it.mapper() }
