package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

class Reports : Fragment(R.layout.fragment_reports) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnBack = view.findViewById<View>(R.id.button2)

        btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_reports_to_mainMenu)
        }
    }
}