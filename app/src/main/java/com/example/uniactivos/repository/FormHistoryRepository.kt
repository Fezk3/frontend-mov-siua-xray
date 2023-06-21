package com.example.uniactivos.repository

import com.example.uniactivos.service.FormHistoryService
class FormHistoryRepository (
    private val formHistoryService: FormHistoryService
    ){

    suspend fun getAllFormsHistory() = formHistoryService.getAll()

}