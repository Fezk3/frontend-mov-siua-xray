package com.example.uniactivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReceiveDynamics.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReceiveDynamics : Fragment(R.layout.fragment_receive_dynamics) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAceptar = view.findViewById<View>(R.id.buttonAceptarActivos)

        btnAceptar.setOnClickListener {
            findNavController().navigate(R.id.action_receiveDynamics_to_pendingAssets)
        }
    }
}