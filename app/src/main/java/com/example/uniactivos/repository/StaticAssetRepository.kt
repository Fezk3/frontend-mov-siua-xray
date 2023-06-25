package com.example.uniactivos.repository
import com.example.uniactivos.service.StaticAssetService

class StaticAssetRepository constructor(
    private val staticAssetService: StaticAssetService
){
    suspend fun getByAssetEstaticoAndClassroomId(classroomNumber: String) =
        staticAssetService.getByAssetEstaticoAndClassroomId(classroomNumber)

    suspend fun getByAssetTypeAndClassroomId(description: String, classroomId: Long) =
        staticAssetService.getByAssetTypeAndClassroomId(description, classroomId)
}