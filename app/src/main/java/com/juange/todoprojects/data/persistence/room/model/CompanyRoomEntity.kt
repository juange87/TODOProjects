package com.juange.todoprojects.data.persistence.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.juange.todoprojects.domain.model.Company

@Entity(tableName = "company")
data class CompanyRoomEntity(
        @PrimaryKey @ColumnInfo(name = "company_id") var id: String = "",
        @ColumnInfo(name = "company_is_owner") var owner: String = "",
        @ColumnInfo(name = "company_name") var name: String = ""
)

fun CompanyRoomEntity.mapper(): Company {
    return Company(
            isOwner = this.owner,
            name = this.name,
            id = this.id
    )
}

fun Collection<CompanyRoomEntity>.mapper(): List<Company> = this.map { it.mapper() }

fun Company.mapper(): CompanyRoomEntity {
    return CompanyRoomEntity(
            owner = this.isOwner,
            name = this.name,
            id = this.id
    )
}

fun List<Company>.mapper(): List<CompanyRoomEntity> = this.map { it.mapper() }
