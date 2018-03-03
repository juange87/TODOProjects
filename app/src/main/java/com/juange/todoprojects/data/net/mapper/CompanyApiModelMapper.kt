package com.juange.todoprojects.data.net.mapper

import com.juange.todoprojects.data.net.model.CompanyApiModel
import com.juange.todoprojects.domain.model.Company
import javax.inject.Inject

class CompanyApiModelMapper @Inject constructor() {

    fun mapToDomain(companyApiModel: CompanyApiModel?): Company {
        return companyApiModel?.let {
            Company(
                    isOwner = it.isOwner,
                    name = it.name,
                    id = it.id
            )
        } ?: Company()
    }
}