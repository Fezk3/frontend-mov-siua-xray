package com.example.uniactivos.service

import com.example.uniactivos.model.ScheduleDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleService {
    @GET("v1/schedules")
    suspend fun getAll(): Response<List<ScheduleDetails>>

    @GET("v1/schedules/user/{userId}")
    suspend fun getByUserId(@Path("userId") userId: Long): Response<List<ScheduleDetails>>

    @GET("v1/schedules/classroom/{classroomId}")
    suspend fun getByClassroomId(@Path("classroomId") classroomId: Long): Response<List<ScheduleDetails>>

    /*
     * Function or any member of the class that can be called without having the instance of the
     * class then you can write the same as a member of a companion object inside the class
     */
    companion object {
        private var service: ScheduleService? = null
        fun getInstance(): ScheduleService {
            if (service == null) {
                service = ServiceBuilder.buildService(ScheduleService::class.java)
            }
            return service!!
        }
    }
}