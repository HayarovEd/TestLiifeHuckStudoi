package com.edurda77.testliifehuckstudoi.data.mappers

import com.edurda77.testliifehuckstudoi.data.remote.CompanyDTO
import com.edurda77.testliifehuckstudoi.data.remote.ResourceCompaniesDTO
import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany

fun List<ResourceCompaniesDTO>.toListCompanyData(): List<ItemCompany> {
    return this.map {
        ItemCompany(
            id = it.id,
            img = it.img,
            name = it.name
        )
    }
}

fun CompanyDTO.toCompanyData(): CompanyData {
    return CompanyData(
        id = this.id,
        img = this.img,
        name = this.name,
        lon = this.lon,
        lat = this.lat,
        description = this.description,
        phone = this.phone,
        website = this.www
    )
}