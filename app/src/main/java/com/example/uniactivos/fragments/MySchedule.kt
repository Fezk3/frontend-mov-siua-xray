package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

/**
 * A simple [Fragment] subclass.
 * Use the [MySchedule.newInstance] factory method to
 * create an instance of this fragment.
 */
class MySchedule : Fragment(R.layout.fragment_my_schedule) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btncheck = view.findViewById<View>(R.id.btn_check)

        btncheck.setOnClickListener{
            findNavController().navigate(R.id.action_mySchedule_to_teacherDynamicForm)
        }


    }

}