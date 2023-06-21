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
import com.example.uniactivos.adapter.ScheduleAdapter
import com.example.uniactivos.databinding.FragmentMyScheduleBinding
import com.example.uniactivos.databinding.FragmentPendingAssetsBinding
import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.ScheduleViewModel

class PendingAssets : Fragment(){
    private var _binding: FragmentMyScheduleBinding? = null
    private val binding get() = _binding!!

    private val scheduleVM: ScheduleViewModel by viewModels()
    private val adapter: ScheduleAdapter = ScheduleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyScheduleBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvschedule.layoutManager = LinearLayoutManager(requireContext())
        binding.rvschedule.adapter = adapter

        scheduleVM.scheduleList.observe(viewLifecycleOwner) {
            adapter.setScheduleList(it)
        }

        scheduleVM.findAllSchedules()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheck.setOnClickListener{
            findNavController().navigate(R.id.action_pendingAssets_to_receiveDynamics3)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}