package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uniactivos.adapter.FormHistoryAdapter
import com.example.uniactivos.databinding.FragmentFormHistoryBinding
import com.example.uniactivos.repository.FormHistoryRepository
import com.example.uniactivos.service.FormHistoryService
import com.example.uniactivos.viewmodel.FormHistoryFactory
import com.example.uniactivos.viewmodel.FormHistoryViewModel
import com.example.uniactivos.viewmodel.ViewModelFactory

class FormHistory : Fragment(){
    private var _binding: FragmentFormHistoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var formHistoryViewModel: FormHistoryViewModel
    private val adapter: FormHistoryAdapter = FormHistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormHistoryBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvFormHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFormHistory.adapter = adapter

        val formHistoryService = FormHistoryService.getInstance()
        val formhistoryrepo = FormHistoryRepository(formHistoryService)

        formHistoryViewModel = ViewModelProvider(this, FormHistoryFactory(formhistoryrepo)).get(FormHistoryViewModel::class.java)

        formHistoryViewModel.formHistoryList.observe(viewLifecycleOwner) {
            adapter.setFormList(it)
        }
        formHistoryViewModel.getAllFormHistory()
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