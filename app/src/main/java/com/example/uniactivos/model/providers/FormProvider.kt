package com.example.uniactivos.model.providers

import com.example.uniactivos.model.FormDetails


class FormProvider {

    companion object {
        fun findById(id: Int): FormDetails {
            return ticketList[id]
        }

        fun findAllTickets(): List<FormDetails> {
            return ticketList
        }

        val ticketList = listOf<FormDetails>(
            FormDetails(
                1,
                null,
            ),
            FormDetails(
                2,
                null,
            ),
            FormDetails(
                3,
                null,
            ),
            FormDetails(
                4,
                null,
            ),
            FormDetails(
                5,
                null,
            )
        )

    }

}