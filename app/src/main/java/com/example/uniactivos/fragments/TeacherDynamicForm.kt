package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R

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