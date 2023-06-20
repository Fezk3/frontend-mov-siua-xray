package com.example.uniactivos.service

import com.example.uniactivos.model.FormDetails
import retrofit2.Response
import retrofit2.http.GET

interface FormService {

    @GET("v1/form")
    suspend fun getAll() : Response<List<FormDetails>>

    companion object{
        var formService : FormService? = null
        fun getInstance() : FormService {
            if (formService == null) {
                formService = ServiceBuilder.buildService(FormService::class.java)
            }
            return formService!!
        }
    }

}