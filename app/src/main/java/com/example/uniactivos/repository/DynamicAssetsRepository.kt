package com.example.uniactivos.repository

import com.example.uniactivos.service.DynamicAssetService

class DynamicAssetsRepository constructor(
    private val dynamicAssetService: DynamicAssetService
){
    suspend fun getByAssetDinamicoAndClassroomId(classroomNumber: String) =
        dynamicAssetService.getByAssetDinamicoAndClassroomId(classroomNumber)

    suspend fun getByAssetTypeAndClassroomId(description: String, classroomId: Long) =
        dynamicAssetService.getByAssetTypeAndClassroomId(description, classroomId)
}