package com.example.uniactivos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uniactivos.repository.StaticAssetRepository

class StaticAssetViewModelFactory (
    private val repository: StaticAssetRepository
): ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(StaticAssetViewModel::class.java)) {
                StaticAssetViewModel(repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
}