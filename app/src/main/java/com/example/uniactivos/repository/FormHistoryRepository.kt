package com.example.uniactivos.repository

import com.example.uniactivos.service.FormHistoryService
import com.example.uniactivos.model.FormHistoryInput
class FormHistoryRepository (
    private val formHistoryService: FormHistoryService
    ){

    suspend fun getAllFormsHistory() = formHistoryService.getAll()

    suspend fun getPendingFormsHistory() = formHistoryService.getPending()

    suspend fun create(forminput: FormHistoryInput) = formHistoryService.create(forminput)

}