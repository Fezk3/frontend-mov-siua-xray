package com.example.uniactivos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uniactivos.repository.DynamicAssetsRepository

class DynamicAssetViewModelFactory(
    private val repository: DynamicAssetsRepository
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DynamicAssetViewModel::class.java)) {
            DynamicAssetViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}