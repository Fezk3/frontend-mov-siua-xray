package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

/**
 * A simple [Fragment] subclass.
 * Use the [Aulas.newInstance] factory method to
 * create an instance of this fragment.
 */
class Aulas : Fragment(R.layout.fragment_aulas) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnDetalle = view.findViewById<View>(R.id.btn_accept)

        btnDetalle.setOnClickListener{
            findNavController().navigate(R.id.action_aulas_to_classroomViewFragment)
        }
    }
}