package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uniactivos.R
import com.example.uniactivos.adapter.ClassroomAdapter
import com.example.uniactivos.databinding.FragmentTeacherDynamicFormBinding
import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModel
import com.example.uniactivos.adapter.DynamicAssetAdapter
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.ScheduleAdapter
import com.example.uniactivos.adapter.ScheduleAdapter.Companion.SCHEDULE_CLASS
import com.example.uniactivos.databinding.DynamicAssetItemBinding
import com.example.uniactivos.repository.DynamicAssetsRepository
import com.example.uniactivos.service.DynamicAssetService
import com.example.uniactivos.viewmodel.DynamicAssetViewModelFactory

class TeacherDynamicForm : Fragment(){
    private var _binding: FragmentTeacherDynamicFormBinding? = null
    private val binding get() = _binding!!

    private lateinit var dynAssetViewModel: DynamicAssetViewModel
    private val adapter: DynamicAssetAdapter = DynamicAssetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeacherDynamicFormBinding.inflate(inflater, container, false)
        val view = binding.root

        val classNumber = arguments?.getString(SCHEDULE_CLASS)
        binding.aulaDynAssetTeach.text = classNumber

        binding.rvDynamicAsset.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDynamicAsset.adapter = adapter

        val dynAssetService = DynamicAssetService.getInstance()
        val dynAssetRepo = DynamicAssetsRepository(dynAssetService)

        dynAssetViewModel = ViewModelProvider(this, DynamicAssetViewModelFactory(dynAssetRepo)).get(
            DynamicAssetViewModel::class.java)

        dynAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapter.setAssetList(it)
        }

        //dynAssetViewModel.findAllDinAssets()
        dynAssetViewModel.getDynByClassroomNumber(classNumber!!)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAceptar.setOnClickListener{
            val classNumber = arguments?.getString(SCHEDULE_CLASS)
            val bundle = bundleOf(CLASS_NUMBER to classNumber.toString())
            findNavController().navigate(R.id.action_teacherDynamicForm_to_teacherStaticForm, bundle)
        }
    }

    companion object {
        const val CLASS_NUMBER = "class_Number"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}