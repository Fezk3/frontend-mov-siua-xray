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
import com.example.uniactivos.adapter.StaticAssetAdapter
import com.example.uniactivos.databinding.FragmentTeacherStaticFormBinding
import com.example.uniactivos.viewmodel.StaticAssetViewModel

class TeacherStaticForm : Fragment(){
    private var _binding: FragmentTeacherStaticFormBinding? = null
    private val binding get() = _binding!!

    private val statAssetViewModel: StaticAssetViewModel by viewModels()
    private val adapter: StaticAssetAdapter = StaticAssetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeacherStaticFormBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvStaticAsset.layoutManager = LinearLayoutManager(requireContext())
        binding.rvStaticAsset.adapter = adapter

        statAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapter.setAssetList(it)
        }

        statAssetViewModel.findAllStatAssets()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button3.setOnClickListener{
            findNavController().navigate(R.id.action_teacherStaticForm_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}