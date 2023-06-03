package com.example.uniactivos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.databinding.FragmentReceiveStaticsBinding

class ReceiveStatics : Fragment(){
    private var _binding: FragmentReceiveStaticsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReceiveStaticsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAceptarActivos.setOnClickListener{
            findNavController().navigate(R.id.action_receiveStatics2_to_homeGuarda)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}