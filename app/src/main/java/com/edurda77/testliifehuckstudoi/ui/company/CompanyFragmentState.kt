package com.edurda77.testliifehuckstudoi.ui.company

import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData

sealed interface CompanyFragmentState {
    object Loading : CompanyFragmentState
    class Failure(val error:String) : CompanyFragmentState
    class Success(val data: CompanyData) : CompanyFragmentState
}