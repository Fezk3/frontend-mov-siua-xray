package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uniactivos.databinding.FragmentProfileBinding
import com.example.uniactivos.viewmodel.LoginViewModel

class Profile : Fragment(){
    private var _binding: FragmentProfileBinding? = null
    private lateinit var loginViewModel: LoginViewModel
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.btnChangePass.setOnClickListener {
            loginViewModel.logout()
            activity?.finish()
        }

        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}