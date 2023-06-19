package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.Classroom
import com.example.uniactivos.model.providers.ClassroomProvider
import com.example.uniactivos.repository.MainRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ClassroomViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val classroom = MutableLiveData<Classroom>()
    val classroomList = MutableLiveData<List<Classroom>>()
    val classroomAssets = MutableLiveData<List<AssetsDetails>?>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null

    fun getAllClassrooms() {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = mainRepository.getAllClassrooms()
            println(mainRepository.getAllClassrooms())
            println(response.body())
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    classroomList.postValue(response.body())
                    loading.value = false
                }else{
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    fun getClassroomById(id: Int) {
        val _classroom = ClassroomProvider.findById(id)
        classroom.postValue(_classroom)
    }

    fun findAllClassrrom() {
        val _classroomList = ClassroomProvider.findAllTickets()
        classroomList.postValue(_classroomList)
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