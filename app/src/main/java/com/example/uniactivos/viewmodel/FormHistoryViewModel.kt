package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.FormHistoryDetails
import com.example.uniactivos.model.FormHistoryInput
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

    fun getAllPendingFormHistory() {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = formHistoryRepository.getPendingFormsHistory()
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

    fun createFormHistory(formHistoryInput: FormHistoryInput) {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            try {
                val response = formHistoryRepository.create(formHistoryInput)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        loading.postValue(false)
                    } else {
                        onError("Error: ${response.message()}")
                    }
                }
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            } finally {
                loading.postValue(false)
            }
        }
    }

    fun updateFormHistory(id: Long) {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            try {
                val response = formHistoryRepository.update(id)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        loading.postValue(false)
                    } else {
                        onError("Error: ${response.message()}")
                        loading.postValue(false)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError("Error: ${e.message}")
                    loading.postValue(false)
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