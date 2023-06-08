package com.example.uniactivos.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R
import com.example.uniactivos.databinding.FragmentClassroomViewBinding

class ClassroomViewFragment : Fragment(){
    private var _binding: FragmentClassroomViewBinding? = null
    private val binding get() = _binding!!
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

        binding.button6.setOnClickListener{
            findNavController().navigate(R.id.action_classroomViewFragment_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}