package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

/**
 * A simple [Fragment] subclass.
 * Use the [ClassroomViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClassroomViewFragment : Fragment(R.layout.fragment_classroom_view) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnVolver = view.findViewById<View>(R.id.button6)

        btnVolver.setOnClickListener {
            findNavController().navigate(R.id.action_classroomViewFragment_to_mainMenu)
        }
    }
}