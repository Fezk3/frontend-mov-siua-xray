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