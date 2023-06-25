package com.example.uniactivos.service

import com.example.uniactivos.model.AssetsDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DynamicAssetService {
    @GET("v1/assets/{estaticos}/{classroomId}")
    suspend fun getByAssetTypeAndClassroomId(@Path("estaticos") description : String,
                                             @Path("classroomId") classroomId : Long): Response<List<AssetsDetails>>

    @GET("v1/assets/dinamicos/{classroomNumber}")
    suspend fun getByAssetDinamicoAndClassroomId(@Path("classroomNumber") classroomNumber : String):
            Response<List<AssetsDetails>>

    /*
     * Function or any member of the class that can be called without having the instance of the
     * class then you can write the same as a member of a companion object inside the class
     */
    companion object {
        private var service: DynamicAssetService? = null
        fun getInstance(): DynamicAssetService {
            if (service == null) {
                service = ServiceBuilder.buildService(DynamicAssetService::class.java)
            }
            return service!!
        }
    }
}