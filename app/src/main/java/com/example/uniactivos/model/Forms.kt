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
    var form: FormDetails? = null,
    var user: UserDetails? = null,
    var date: String? = null,
    var state: StatusDetails? = null,
)

data class FormHistoryInput(
    var formId: Long? = null,
    var userId: Long? = null,
    var statusId: Long? = null,
    var date: Date? = null,
)