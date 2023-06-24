package com.example.uniactivos.model.providers

import com.example.uniactivos.model.Classroom
import com.example.uniactivos.model.College

class ClassroomProvider {

    companion object {
        fun findById(id: Int): Classroom {
            return classroomList[id]
        }

        fun findAllTickets(): List<Classroom> {
            return classroomList
        }

        val classroomList = listOf<Classroom>(
            Classroom(
                1,
                "A12",
                College(
                    1,
                    "UNA",
                ),
            ),
            Classroom(
                2,
                "A11",
                College(
                    1,
                    "UNA",
                ),
            ),
            Classroom(
                3,
                "A13",
                College(
                    1,
                    "UNA",
                ),
            ),
            Classroom(
                4,
                "A14",
                College(
                    1,
                    "UNA",
                ),
            ),
            Classroom(
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