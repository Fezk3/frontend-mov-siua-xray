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
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.StaticAssetAdapter
import com.example.uniactivos.databinding.FragmentTeacherStaticFormBinding
import com.example.uniactivos.model.FormHistoryInput
import com.example.uniactivos.repository.FormHistoryRepository
import com.example.uniactivos.repository.StaticAssetRepository
import com.example.uniactivos.service.FormHistoryService
import com.example.uniactivos.service.StaticAssetService
import com.example.uniactivos.viewmodel.FormHistoryFactory
import com.example.uniactivos.viewmodel.FormHistoryViewModel
import com.example.uniactivos.viewmodel.StaticAssetViewModel
import com.example.uniactivos.viewmodel.StaticAssetViewModelFactory

class TeacherStaticForm : Fragment(){
    private var _binding: FragmentTeacherStaticFormBinding? = null
    private val binding get() = _binding!!

    private lateinit var statAssetViewModel: StaticAssetViewModel
    private lateinit var formHistoryViewModel: FormHistoryViewModel
    private val adapter: StaticAssetAdapter = StaticAssetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeacherStaticFormBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvStaticAsset.layoutManager = LinearLayoutManager(requireContext())
        binding.rvStaticAsset.adapter = adapter

        //val classNumber = arguments?.getString(FormHistoryPendingAdapter.CLASSNUMBER)
        val classNumber = arguments?.getString(TeacherDynamicForm.CLASS_NUMBER)

        val statAssetService = StaticAssetService.getInstance()
        val statAssetRepo = StaticAssetRepository(statAssetService)

        statAssetViewModel = ViewModelProvider(this, StaticAssetViewModelFactory(statAssetRepo)).get(
            StaticAssetViewModel::class.java)

        statAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapter.setAssetList(it)
        }

        //statAssetViewModel.findAllStatAssets()
        statAssetViewModel.getStatByClassroomNumber(classNumber!!) //"C-18"

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formHistoryService = FormHistoryService.getInstance()
        val formhistoryrepo = FormHistoryRepository(formHistoryService)

        formHistoryViewModel = ViewModelProvider(this, FormHistoryFactory(formhistoryrepo)).get(FormHistoryViewModel::class.java)

        binding.button3.setOnClickListener{
            formHistoryViewModel.createFormHistory(FormHistoryInput(userId = 1, date = "26/06/2023", state = "Recibido", classroomNumber = "C-18", formid = 1))
            findNavController().navigate(R.id.action_teacherStaticForm_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}