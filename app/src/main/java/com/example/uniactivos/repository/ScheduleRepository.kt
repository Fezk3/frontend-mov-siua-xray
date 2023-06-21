package com.example.uniactivos.repository

import com.example.uniactivos.service.ScheduleService

class ScheduleRepository constructor(
    private val scheduleService: ScheduleService
){
    suspend fun getAll() = scheduleService.getAll()

    suspend fun getByUserId(userId: Long) = scheduleService.getByUserId(userId)

    suspend fun getByClassroomId(classroomId: Long) = scheduleService.getByClassroomId(classroomId)
}