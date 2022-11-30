package com.edurda77.testliifehuckstudoi.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.testliifehuckstudoi.domain.usecases.AllCompaniesUseCase
import com.edurda77.testliifehuckstudoi.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: AllCompaniesUseCase) : ViewModel() {

    private val _allData =
        MutableLiveData<MainFragmentState>(MainFragmentState.Loading)
    val allData = _allData

    init {
        getAllData()
    }

    private fun getAllData() {
        viewModelScope.launch {
            when (val result = useCase.execute()) {
                is Resource.Success -> {
                    _allData.value = MainFragmentState.Success(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _allData.value = MainFragmentState.Failure(result.message.toString())
                }
            }
        }
    }
}