package com.example.uniactivos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uniactivos.repository.FormHistoryRepository

class FormHistoryFactory (
    private val repository: FormHistoryRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(FormHistoryViewModel::class.java)) {
                FormHistoryViewModel(repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
    }
}