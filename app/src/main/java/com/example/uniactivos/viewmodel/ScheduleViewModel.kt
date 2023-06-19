package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.ScheduleDetails
import com.example.uniactivos.model.providers.ScheduleProvider

class ScheduleViewModel : ViewModel() {

    var scheduleList = MutableLiveData<List<ScheduleDetails>>()

    fun findAllSchedules() {
       val _scheduleDetail = ScheduleProvider.findAllSchedules()
        scheduleList.postValue(_scheduleDetail)
    }

}