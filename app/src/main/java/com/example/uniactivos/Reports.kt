package com.example.uniactivos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.databinding.FragmentReportsBinding

class Reports : Fragment(){
    private var _binding: FragmentReportsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener{
            findNavController().navigate(R.id.action_reports_to_mainMenu2)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}