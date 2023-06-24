package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uniactivos.R
import com.example.uniactivos.adapter.ClassroomAdapter
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.ScheduleAdapter
import com.example.uniactivos.databinding.FragmentMyScheduleBinding
import com.example.uniactivos.databinding.FragmentPendingAssetsBinding
import com.example.uniactivos.repository.FormHistoryRepository
import com.example.uniactivos.service.FormHistoryService
import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.FormHistoryFactory
import com.example.uniactivos.viewmodel.FormHistoryViewModel
import com.example.uniactivos.viewmodel.ScheduleViewModel

class PendingAssets : Fragment(){
    private var _binding: FragmentPendingAssetsBinding? = null
    private val binding get() = _binding!!

    private lateinit var formHistoryViewModel: FormHistoryViewModel

    private val adapter: FormHistoryPendingAdapter = FormHistoryPendingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPendingAssetsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvscheduleGuard.layoutManager = LinearLayoutManager(requireContext())
        binding.rvscheduleGuard.adapter = adapter

        val formHistoryService = FormHistoryService.getInstance()
        val formhistoryrepo = FormHistoryRepository(formHistoryService)

        formHistoryViewModel = ViewModelProvider(this, FormHistoryFactory(formhistoryrepo)).get(FormHistoryViewModel::class.java)

        formHistoryViewModel.formHistoryList.observe(viewLifecycleOwner) {
            adapter.setFormList(it)
        }

        formHistoryViewModel.getAllPendingFormHistory()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.btnCheck.setOnClickListener{
            findNavController().navigate(R.id.action_pendingAssets_to_receiveDynamics3)
        }*/
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}