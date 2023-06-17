package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R
import com.example.uniactivos.databinding.FragmentClassroomViewBinding
import com.example.uniactivos.viewmodel.ClassroomViewModel

class ClassroomViewFragment : Fragment(){
    private var _binding: FragmentClassroomViewBinding? = null
    private val binding get() = _binding!!
    private val classroomViewModel: ClassroomViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassroomViewBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val classroomId = arguments?.getInt("classroomId")
        val classroomData = classroomViewModel.getClassroom() // Obtener los datos de alguna fuente de datos

        // Vincular los datos a los elementos de la interfaz de usuario utilizando el enlace de datos
        //binding.fecha.text = classroomData.toString()
        classroomViewModel.classroom.observe(viewLifecycleOwner) {
            binding.fecha.text = it.classNumber
        }


        binding.button6.setOnClickListener{
            findNavController().navigate(R.id.action_classroomViewFragment_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}