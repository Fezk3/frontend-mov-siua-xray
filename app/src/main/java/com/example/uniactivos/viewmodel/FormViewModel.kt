package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.FormDetails
import com.example.uniactivos.model.providers.FormProvider


class FormViewModel : ViewModel(){

    val formDetail =  MutableLiveData<FormDetails>()
    val formDetailList = MutableLiveData<List<FormDetails>>()

    fun getform() {
        val position = (0..2).random()
        val _formDetail = FormProvider.findById(position)
        formDetail.postValue(_formDetail)
    }

    fun findAllforms() {
        val _formDetailList = FormProvider.findAllTickets()
        formDetailList.postValue(_formDetailList)
    }

}