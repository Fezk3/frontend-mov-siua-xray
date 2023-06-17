package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.ClassroomDetails
import com.example.uniactivos.model.providers.ClassroomProvider

class ClassroomViewModel : ViewModel(){

    val classroom =  MutableLiveData<ClassroomDetails>()
    val classroomList = MutableLiveData<List<ClassroomDetails>>()
    val classroomAssets =  MutableLiveData<List<AssetsDetails>?>()

    fun getClassroom() {
        val position = (0..2).random()
        val _classroom = ClassroomProvider.findById(position)
        classroom.postValue(_classroom)
    }

    fun getClassroomById(id: Int) {
        val _classroom = ClassroomProvider.findById(id)
        classroom.postValue(_classroom)
    }

    /*fun getAssets() {
        val position = (0..2).random()
        val _classroomAssets = ClassroomProvider.findById(position).assetsList
        classroomAssets.postValue(_classroomAssets)
    }*/

    fun findAllClassrrom() {
        val _classroomList = ClassroomProvider.findAllTickets()
        classroomList.postValue(_classroomList)
    }

}