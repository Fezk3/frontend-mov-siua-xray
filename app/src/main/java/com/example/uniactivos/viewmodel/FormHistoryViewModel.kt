package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.FormHistoryDetails
import com.example.uniactivos.model.providers.FormHistoryProvider
import com.example.uniactivos.repository.FormHistoryRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class FormHistoryViewModel(private val formHistoryRepository: FormHistoryRepository) : ViewModel() {

    val formHistoryList = MutableLiveData<List<FormHistoryDetails>>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null
    val errorMessage = MutableLiveData<String>()

    fun getAllFormHistory() {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = formHistoryRepository.getAllFormsHistory()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    formHistoryList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}