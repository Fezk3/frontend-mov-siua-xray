package com.example.uniactivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TeacherDynamicForm.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeacherDynamicForm : Fragment(R.layout.fragment_teacher_dynamic_form) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAceptar = view.findViewById<View>(R.id.btn_aceptar)

        btnAceptar.setOnClickListener{
            findNavController().navigate(R.id.action_teacherDynamicForm_to_teacherStaticForm)
        }
    }
}