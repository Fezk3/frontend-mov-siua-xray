package com.example.uniactivos.model

data class ScheduleDetails(
    var id: Long? = null,
    var courseName: String? = null,
    var date: String? = null,
    var startTime: String? = null,
    var endTime: String? = null,
    var userId: Long? = null,
    var classroom: Classroom? = null,
)