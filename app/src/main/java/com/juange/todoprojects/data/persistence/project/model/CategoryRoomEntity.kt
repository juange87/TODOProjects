package com.juange.todoprojects.data.persistence.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.juange.todoprojects.domain.project.model.Category

@Entity(tableName = "category")
data class CategoryRoomEntity(
        @PrimaryKey @ColumnInfo(name = "category_id") var id: String = "",
        @ColumnInfo(name = "category_color") var color: String = "",
        @ColumnInfo(name = "category_name") var name: String = ""
)

fun CategoryRoomEntity.mapToDomain(): Category {
    return Category(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun Collection<CategoryRoomEntity>.mapToDomain(): List<Category> = this.map { it.mapToDomain() }

fun Category.mapToEntity(): CategoryRoomEntity {
    return CategoryRoomEntity(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun List<Category>.mapToEntity(): List<CategoryRoomEntity> = this.map { it.mapToEntity() }
