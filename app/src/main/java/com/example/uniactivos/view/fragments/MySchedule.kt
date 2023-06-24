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
import com.example.uniactivos.adapter.ScheduleAdapter
import com.example.uniactivos.databinding.FragmentMyScheduleBinding
import com.example.uniactivos.repository.MainRepository
import com.example.uniactivos.repository.ScheduleRepository
import com.example.uniactivos.service.MainService
import com.example.uniactivos.service.ScheduleService
import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.ScheduleModelFactory
import com.example.uniactivos.viewmodel.ScheduleViewModel
import com.example.uniactivos.viewmodel.ViewModelFactory

class MySchedule : Fragment(){
    private var _binding: FragmentMyScheduleBinding? = null
    private val binding get() = _binding!!

    private lateinit var scheduleViewModel: ScheduleViewModel
    private val adapter: ScheduleAdapter = ScheduleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyScheduleBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvFormHistoryProfessor.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFormHistoryProfessor.adapter = adapter

        val scheduleService = ScheduleService.getInstance()
        val scheduleRepository = ScheduleRepository(scheduleService)

        scheduleViewModel = ViewModelProvider(this, ScheduleModelFactory(scheduleRepository)).get(ScheduleViewModel::class.java)

        scheduleViewModel.scheduleList.observe(viewLifecycleOwner) {
            adapter.setScheduleList(it)
        }

        scheduleViewModel.findAllSchedules()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.action_mySchedule2_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}