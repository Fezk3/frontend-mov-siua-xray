package com.example.uniactivos.repository
import com.example.uniactivos.service.MainService


class MainRepository constructor(
    private val mainService: MainService
){
    suspend fun getAllClassrooms() = mainService.getAll()

}