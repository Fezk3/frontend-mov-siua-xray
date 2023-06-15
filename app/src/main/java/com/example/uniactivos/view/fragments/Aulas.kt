package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uniactivos.R
import com.example.uniactivos.adapter.ClassroomAdapter
import com.example.uniactivos.databinding.FragmentAulasBinding
import com.example.uniactivos.viewmodel.ClassroomViewModel

class Aulas : Fragment(){
    private var _binding: FragmentAulasBinding? = null
    private val binding get() = _binding!!

    private val classroomViewModel: ClassroomViewModel by viewModels()
    private val adapter: ClassroomAdapter = ClassroomAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAulasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvClassrooms.layoutManager = LinearLayoutManager(requireContext())
        binding.rvClassrooms.adapter = adapter

        classroomViewModel.classroomList.observe(viewLifecycleOwner) {
            adapter.setClassroomList(it)
        }

        classroomViewModel.findAllClassrrom()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccept.setOnClickListener{
            findNavController().navigate(R.id.action_aulas_to_classroomViewFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
