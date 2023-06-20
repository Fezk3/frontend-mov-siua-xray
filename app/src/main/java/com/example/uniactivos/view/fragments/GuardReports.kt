package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uniactivos.adapter.FormHistoryAdapter
import com.example.uniactivos.databinding.FragmentGuardReportsBinding
import com.example.uniactivos.model.providers.FormHistoryProvider
import com.example.uniactivos.viewmodel.FormHistoryViewModel

class GuardReports : Fragment(){
//    private var _binding: FragmentGuardReportsBinding? = null
//    private val binding get() = _binding!!
//
//    val formhisViewModel = FormHistoryViewModel()
//    val adapter = FormHistoryAdapter()
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentGuardReportsBinding.inflate(inflater, container, false)
//        val view = binding.root
//
//        binding.rvrepos.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvrepos.adapter = adapter
//
//        formhisViewModel.formHistoryList.observe(viewLifecycleOwner) {
//            adapter.setFormList(it)
//        }
//
//        return view
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}