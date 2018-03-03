package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.CategoryApiModel
import com.juange.todoprojects.domain.model.Category
import javax.inject.Inject

class CategoryApiModelMapper @Inject constructor() {

    fun mapToDomain(categoryApiModel: CategoryApiModel?): Category {
        return categoryApiModel?.let {
            Category(
                    color = it.color,
                    name = it.name,
                    id = it.id
            )
        } ?: Category()
    }
}