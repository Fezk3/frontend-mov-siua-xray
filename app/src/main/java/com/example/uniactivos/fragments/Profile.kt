package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnChangePass = view.findViewById<View>(R.id.btnChangePass)

        btnChangePass.setOnClickListener {
            findNavController().navigate(R.id.action_profile2_to_passwordChange)
        }
    }
}