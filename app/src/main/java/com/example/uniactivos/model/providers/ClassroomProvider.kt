package com.example.uniactivos.model.providers

import com.example.uniactivos.model.ClassroomDetails
import com.example.uniactivos.model.College

class ClassroomProvider {

    companion object {
        fun findById(id: Int): ClassroomDetails {
            return classroomList[id]
        }

        fun findAllTickets(): List<ClassroomDetails> {
            return classroomList
        }

        val classroomList = listOf<ClassroomDetails>(
            ClassroomDetails(
                1,
                "A12",
                College(
                    1,
                    "UNA",
                ),
            ),
            ClassroomDetails(
                2,
                "A11",
                College(
                    1,
                    "UNA",
                ),
            ),
            ClassroomDetails(
                3,
                "A13",
                College(
                    1,
                    "UNA",
                ),
            ),
            ClassroomDetails(
                4,
                "A14",
                College(
                    1,
                    "UNA",
                ),
            ),
            ClassroomDetails(
                5,
                "A12",
                College(
                    1,
                    "UNA",
                ),
            )
        )

    }

}