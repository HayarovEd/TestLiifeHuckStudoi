package com.edurda77.testliifehuckstudoi.ui.main

import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany

sealed interface MainFragmentState {
    object Loading : MainFragmentState
    class Failure(val error:String) : MainFragmentState
    class Success(val data: List<ItemCompany>) : MainFragmentState
}