package com.example.uniactivos.model

import java.util.Date

data class FormDetails(
    var id: Long? = null,
    var classroom: Classroom? = null,
)

data class StatusDetails(
    var id: Long? = null,
    var description: String? = null,
)

data class FormHistoryDetails(
    var id: Long? = null,
    var formid: Long? = null,
    var userId: Long? = null,
    var date: Date? = null,
    var state: String? = null,
    var classroomNumber: String? = null,
)

data class FormHistoryInput(
    var formid: Long? = null,
    var userId: Long? = null,
    var date: String? = null,
    var state: String? = null,
    var classroomNumber : String? = null,
)
