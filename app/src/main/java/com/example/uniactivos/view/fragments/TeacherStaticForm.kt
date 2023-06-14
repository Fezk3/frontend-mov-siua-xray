package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R
import com.example.uniactivos.databinding.FragmentTeacherStaticFormBinding

class TeacherStaticForm : Fragment(){
    private var _binding: FragmentTeacherStaticFormBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeacherStaticFormBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button3.setOnClickListener{
            findNavController().navigate(R.id.action_teacherStaticForm_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}