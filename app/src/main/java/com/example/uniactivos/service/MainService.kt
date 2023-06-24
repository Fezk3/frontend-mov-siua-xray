package com.example.uniactivos.service

import com.example.uniactivos.model.Classroom
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MainService {

    @GET("v1/classrooms")
    suspend fun getAll() : Response<List<Classroom>>
    @GET("v1/classrooms/{classNumber}")
    suspend fun getByClassNumber(@Path("classNumber") classNumber: String) : Response<Classroom>

    @GET("v1/classrooms/{collegeName}")
    suspend fun getByCollegeName(@Path("collegeName") collegeName: String) : Response<Classroom>

    companion object{
        var mainService : MainService? = null
        fun getInstance() : MainService {
            if (mainService == null) {
                mainService = ServiceBuilder.buildService(MainService::class.java)
            }
            return mainService!!
        }
    }
}