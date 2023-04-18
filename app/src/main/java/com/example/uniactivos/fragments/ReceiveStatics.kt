package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

class ReceiveStatics : Fragment(R.layout.fragment_receive_statics) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAceptar = view.findViewById<View>(R.id.buttonAceptarActivos)

        btnAceptar.setOnClickListener {
            findNavController().navigate(R.id.action_receiveStatics_to_receiveDynamics)
        }
    }
}