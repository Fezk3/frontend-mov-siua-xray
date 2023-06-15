package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.FormDetails
import com.example.uniactivos.model.providers.FormProvider


class FormViewModel : ViewModel(){

    val FormDetail =  MutableLiveData<FormDetails>()
    val FormDetailList = MutableLiveData<List<FormDetails>>()

    fun getTicket() {
        val position = (0..2).random()
        val _formDetail = FormProvider.findById(position)
        FormDetail.postValue(_formDetail)
    }

    fun findAllTicket() {
        val _formDetailList = FormProvider.findAllTickets()
        FormDetailList.postValue(_formDetailList)
    }

}