package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.FormDetails
import com.example.uniactivos.model.providers.FormProvider


class FormViewModel : ViewModel(){

    val ticket =  MutableLiveData<FormDetails>()
    val ticketList = MutableLiveData<List<FormDetails>>()

    fun getTicket() {
        val position = (0..2).random()
        val _ticket = FormProvider.findById(position)
        ticket.postValue(_ticket)
    }

    fun findAllTicket() {
        val _ticketList = FormProvider.findAllTickets()
        ticketList.postValue(_ticketList)
    }

}