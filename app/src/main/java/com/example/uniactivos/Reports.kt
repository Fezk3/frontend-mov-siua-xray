package com.example.uniactivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class Reports : Fragment(R.layout.fragment_reports) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnBack = view.findViewById<View>(R.id.button2)

        btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_reports_to_mainMenu)
        }
    }
}