package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.Classroom
import com.example.uniactivos.model.ScheduleDetails
import com.example.uniactivos.model.providers.ClassroomProvider
import com.example.uniactivos.model.providers.ScheduleProvider
import com.example.uniactivos.repository.MainRepository
import com.example.uniactivos.repository.ScheduleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleViewModel(private val scheduleRepository: ScheduleRepository) : ViewModel() {

    val schedule = MutableLiveData<ScheduleDetails>()
    val scheduleList = MutableLiveData<List<ScheduleDetails>>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null

    fun findAllSchedules() {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = scheduleRepository.getAll()
            println(scheduleRepository.getAll())
            println(response.body())
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    scheduleList.postValue(response.body())
                    loading.value = false
                }else{
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    fun getByClassroomId(id: Long) {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = scheduleRepository.getByClassroomId(id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    scheduleList.postValue(response.body())
                    loading.value = false
                }else{
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    /*fun findAllSchedules() {
        val _scheduleDetail = ScheduleProvider.findAllSchedules()
        scheduleList.postValue(_scheduleDetail)
    } */

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}