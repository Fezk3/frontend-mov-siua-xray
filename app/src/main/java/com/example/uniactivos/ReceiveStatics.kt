package com.example.uniactivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class ReceiveStatics : Fragment(R.layout.fragment_receive_statics) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAceptar = view.findViewById<View>(R.id.buttonAceptarActivos)
        var btnRechazar = view.findViewById<View>(R.id.buttonRechazarActivos)

        btnAceptar.setOnClickListener {
            findNavController().navigate(R.id.action_receiveStatics_to_mainMenu)
        }
        btnRechazar.setOnClickListener {
            findNavController().navigate(R.id.action_receiveStatics_to_mainMenu)
        }
    }
}