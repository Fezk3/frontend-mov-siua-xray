package com.example.uniactivos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.databinding.FragmentReceiveDynamicsBinding

class ReceiveDynamics : Fragment(){
    private var _binding: FragmentReceiveDynamicsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReceiveDynamicsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAceptarActivos.setOnClickListener{
            findNavController().navigate(R.id.action_receiveDynamics3_to_receiveStatics2)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}