package com.juange.todoprojects.data.persistence.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.juange.todoprojects.domain.model.Tag

@Entity(tableName = "tag")
data class TagRoomEntity(
        @PrimaryKey @ColumnInfo(name = "tag_id") var id: String = "",
        @ColumnInfo(name = "tag_color") var color: String = "",
        @ColumnInfo(name = "tag_name") var name: String = ""
)

fun TagRoomEntity.mapper(): Tag {
    return Tag(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun Collection<TagRoomEntity>.mapper(): List<Tag> = this.map { it.mapper() }

fun Tag.mapper(): TagRoomEntity {
    return TagRoomEntity(
            color = this.color,
            name = this.name,
            id = this.id
    )
}

fun List<Tag>.mapper(): List<TagRoomEntity> = this.map { it.mapper() }
