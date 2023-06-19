package com.example.uniactivos.service

import com.example.uniactivos.model.FormHistoryDetails
import com.example.uniactivos.model.FormHistoryInput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FormHistoryService {

    @GET("v1/form-history")
    suspend fun getAll() : Response<List<FormHistoryDetails>>

    @POST("v1/form-history")
    suspend fun create(@Body forminput: FormHistoryInput) : Response<FormHistoryDetails>

    companion object{
        var formHistoryService : FormHistoryService? = null
        fun getInstance() : FormHistoryService {
            if (formHistoryService == null) {
                formHistoryService = ServiceBuilder.buildService(FormHistoryService::class.java)
            }
            return formHistoryService!!
        }
    }

}