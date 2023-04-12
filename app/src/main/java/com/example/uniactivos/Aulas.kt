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
