package com.example.uniactivos.model.providers

import com.example.uniactivos.model.Classroom
import com.example.uniactivos.model.College
import com.example.uniactivos.model.ScheduleDetails

class ScheduleProvider {

    companion object {

        fun findById(id: Int): ScheduleDetails {
            return scheduleList[id]
        }

        fun findAllSchedules(): List<ScheduleDetails> {
            return scheduleList
        }

        fun findByUserId(userId: Int): ScheduleDetails {
            return scheduleList[userId]
        }

        val scheduleList = listOf<ScheduleDetails>(
            ScheduleDetails(
                1,
                "Inge",
                "11-11-11",
                "1pm",
                "2pm",
                1,
                Classroom(
                    1,
                    "A",
                    College(
                        1,
                        "Ingenieria",
                    )
                )
            ),
            ScheduleDetails(
                2,
                null,
            ),
            ScheduleDetails(
                3,
                null,
            ),
            ScheduleDetails(
                4,
                null,
            ),
            ScheduleDetails(
                5,
                null,
            )
        )

    }

}