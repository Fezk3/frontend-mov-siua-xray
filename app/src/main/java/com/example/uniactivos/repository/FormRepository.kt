package com.example.uniactivos.repository

import com.example.uniactivos.service.FormService

class FormRepository(
    private val formService: FormService
) {

    suspend fun getAllForms() = formService.getAll()


}