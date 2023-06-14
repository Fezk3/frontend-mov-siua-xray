package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.R
import com.example.uniactivos.databinding.FragmentHomeGuardaBinding

class HomeGuarda : Fragment(){
    private var _binding: FragmentHomeGuardaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeGuardaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardViewReciboProfesor.setOnClickListener{
            findNavController().navigate(R.id.action_homeGuarda_to_pendingAssets)
        }
        binding.cardViewReporte.setOnClickListener{
            findNavController().navigate(R.id.action_homeGuarda_to_reports)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}