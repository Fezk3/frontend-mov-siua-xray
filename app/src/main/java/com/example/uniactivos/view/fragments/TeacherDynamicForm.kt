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
import com.example.uniactivos.databinding.FragmentTeacherDynamicFormBinding
import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModel
import com.example.uniactivos.adapter.DynamicAssetAdapter
import com.example.uniactivos.databinding.DynamicAssetItemBinding

class TeacherDynamicForm : Fragment(){
    private var _binding: FragmentTeacherDynamicFormBinding? = null
    private val binding get() = _binding!!

    private val dynAssetViewModel: DynamicAssetViewModel by viewModels()
    private val adapter: DynamicAssetAdapter = DynamicAssetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeacherDynamicFormBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvDynamicAsset.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDynamicAsset.adapter = adapter

        dynAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapter.setAssetList(it)
        }

        dynAssetViewModel.findAllDinAssets()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAceptar.setOnClickListener{
            findNavController().navigate(R.id.action_teacherDynamicForm_to_teacherStaticForm)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}