package com.edurda77.testliifehuckstudoi.ui.company

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import com.edurda77.testliifehuckstudoi.domain.usecases.CompanyUseCase
import com.edurda77.testliifehuckstudoi.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(private val useCase: CompanyUseCase) : ViewModel() {
    private val _companyData =
        MutableLiveData<CompanyFragmentState>(CompanyFragmentState.Loading)
    val companyData = _companyData


    fun getCompanyData(id: String) {
        viewModelScope.launch {
            when (val result = useCase.execute(id = id)) {
                is Resource.Success -> {
                    _companyData.value = CompanyFragmentState.Success(result.data ?: CompanyData())
                }
                is Resource.Error -> {
                    _companyData.value = CompanyFragmentState.Failure(result.message.toString())
                }
            }
        }
    }
}