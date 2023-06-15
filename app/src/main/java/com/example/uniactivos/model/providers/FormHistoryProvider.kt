package com.example.uniactivos.model.providers

import com.example.uniactivos.model.ClassroomDetails
import com.example.uniactivos.model.College
import com.example.uniactivos.model.FormDetails
import com.example.uniactivos.model.FormHistoryDetails
import com.example.uniactivos.model.StatusDetails
import com.example.uniactivos.model.UserDetails


class FormHistoryProvider {

    companion object {
        fun findById(id: Int): FormHistoryDetails {
            return formhisList[id]
        }

        fun findAllFormHis(): List<FormHistoryDetails> {
            return formhisList
        }

        val formhisList = listOf<FormHistoryDetails>(
            FormHistoryDetails(
                1,
                FormDetails(
                    1,
                    ClassroomDetails(
                        1,
                        "A12",
                        College(
                            1,
                            "UNA",
                        ),
                    ),
                ),
                UserDetails(
                    1,
                    "Juan",
                    "Perez",
                    "12345678",
                    null),
                "2021-10-10",
                StatusDetails(
                    1,
                    "Aceptado",
                ),
            ),
            FormHistoryDetails(
                2,
                FormDetails(
                    1,
                    ClassroomDetails(
                        1,
                        "A12",
                        College(
                            1,
                            "UNA",
                        ),
                    ),
                ),
                UserDetails(
                    1,
                    "Juan",
                    "Perez",
                    "12345678",
                    null),
                "2021-10-10",
                StatusDetails(
                    1,
                    "Aceptado",
                ),
            ),
        )

    }

}