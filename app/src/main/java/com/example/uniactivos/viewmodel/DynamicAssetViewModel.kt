package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.AssetTypeDetails
import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.providers.DynamicAssetProvider
import com.example.uniactivos.repository.DynamicAssetsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DynamicAssetViewModel(private val dynamicAssetRepository: DynamicAssetsRepository) : ViewModel(){
    val assetDetail =  MutableLiveData<AssetsDetails>()
    val assetDetailList = MutableLiveData<List<AssetsDetails>>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null

    fun getDynByAssetTypeAndClassroomId(description : String, classroomId : Long) {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = dynamicAssetRepository.getByAssetTypeAndClassroomId(description, classroomId)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    assetDetailList.postValue(response.body())
                    loading.value = false
                }else{
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    fun getDynByClassroomNumber(classroomNumber : String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            loading.postValue(true)
            val response = dynamicAssetRepository.getByAssetDinamicoAndClassroomId(classroomNumber)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    assetDetailList.postValue(response.body())
                    loading.value = false
                }else{
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    fun findAllDinAssets() {
        val _assetDetailList = DynamicAssetProvider.findAllAssets()
        assetDetailList.postValue(_assetDetailList)
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