package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.TagApiModel
import com.juange.todoprojects.domain.model.Tag
import javax.inject.Inject

class TagApiModelMapper @Inject constructor() {

    fun mapToDomain(tagApiModel: TagApiModel?): Tag {
        return tagApiModel?.let {
            Tag(
                    color = it.color,
                    name = it.name,
                    id = it.id
            )
        } ?: Tag()
    }

    fun mapToDomain(list: List<TagApiModel>?): List<Tag> {
        return list?.map { mapToDomain(it) } ?: emptyList()
    }
}