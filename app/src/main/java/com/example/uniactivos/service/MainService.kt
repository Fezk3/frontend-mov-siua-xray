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
    suspend fun getAll(@Header("Authorization") Token: String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzZWN1cmUtYXBpIiwiYXVkIjoic2VjdXJlLWFwcCIsInN1YiI6InNlZ0BnbWFpbC5jb20iLCJleHAiOjE2ODc4OTc1MDl9.jBoWVl1eKTc4DTwixWNWx5-mre626rU_T7KEzcwUu6m9JgSINmKxyhsMCOLmwPJYSCp0358exDIF50wcUbhPuA"): Response<List<Classroom>>

    @GET("v1/classrooms/{classNumber}")
    suspend fun getByClassNumber(@Path("classNumber") classNumber: String) : Response<Classroom>

    @GET("v1/classrooms/{collegeName}")
    suspend fun getByCollegeName(@Path("collegeName") collegeName: String) : Response<Classroom>

    companion object{
        var mainService : MainService? = null
        fun getInstance() : MainService {
            if (mainService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://uniactivosxray-app-v01.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                mainService = retrofit.create(MainService::class.java)
            }
            return mainService!!
        }
    }
}