package com.example.uniactivos.service

import com.example.uniactivos.model.Classroom
import com.example.uniactivos.model.FormHistoryDetails
import com.example.uniactivos.model.FormHistoryInput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FormHistoryService {

    @GET("v1/forms-history")
    suspend fun getAll() : Response<List<FormHistoryDetails>>

    @POST("v1/forms-history")
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

    @GET("v1/forms-history/pendientes")
    suspend fun getPending() : Response<List<FormHistoryDetails>>

}

