package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.FormHistoryDetails
import com.example.uniactivos.model.providers.FormHistoryProvider

class FormHistoryViewModel : ViewModel(){

    val formHistoryList = MutableLiveData<List<FormHistoryDetails>>()

    fun findAllFormHis() {
        val _formHistoryList = FormHistoryProvider.findAllFormHis()
        formHistoryList.postValue(_formHistoryList)
    }

}