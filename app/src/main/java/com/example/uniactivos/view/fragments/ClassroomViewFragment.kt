package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uniactivos.R
import com.example.uniactivos.adapter.ClassroomAdapter.Companion.CLASSROOM_ID
import com.example.uniactivos.adapter.DynamicAssetAdapter
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.StaticAssetAdapter
import com.example.uniactivos.databinding.FragmentClassroomViewBinding
import com.example.uniactivos.repository.DynamicAssetsRepository
import com.example.uniactivos.repository.StaticAssetRepository
import com.example.uniactivos.service.DynamicAssetService
import com.example.uniactivos.service.StaticAssetService

import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModelFactory
import com.example.uniactivos.viewmodel.FormHistoryViewModel
import com.example.uniactivos.viewmodel.StaticAssetViewModel
import com.example.uniactivos.viewmodel.StaticAssetViewModelFactory

class ClassroomViewFragment : Fragment(){
    //private var _binding: FragmentClassroomViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var classroomViewModel: ClassroomViewModel
    private var _binding: FragmentClassroomViewBinding? = null

    private lateinit var dynAssetViewModel: DynamicAssetViewModel
    private val adapterDyn: DynamicAssetAdapter = DynamicAssetAdapter()
    private lateinit var statAssetViewModel: StaticAssetViewModel
    private val adapterStat: StaticAssetAdapter = StaticAssetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClassroomViewBinding.inflate(inflater, container, false)
        val view = binding.root

        val classNumber = arguments?.getString(CLASSROOM_ID)
        binding.titleaula.text = classNumber

        binding.rvDynamicAssetAula.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDynamicAssetAula.adapter = adapterDyn

        val dynAssetService = DynamicAssetService.getInstance()
        val dynAssetRepo = DynamicAssetsRepository(dynAssetService)

        dynAssetViewModel = ViewModelProvider(this, DynamicAssetViewModelFactory(dynAssetRepo)).get(
            DynamicAssetViewModel::class.java)

        dynAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapterDyn.setAssetList(it)
        }

        //dynAssetViewModel.findAllDinAssets()
        dynAssetViewModel.getDynByClassroomNumber(classNumber!!)

        binding.rvStaticAssetAula.layoutManager = LinearLayoutManager(requireContext())
        binding.rvStaticAssetAula.adapter = adapterStat

        val statAssetService = StaticAssetService.getInstance()
        val statAssetRepo = StaticAssetRepository(statAssetService)

        statAssetViewModel = ViewModelProvider(this, StaticAssetViewModelFactory(statAssetRepo)).get(
            StaticAssetViewModel::class.java)

        statAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapterStat.setAssetList(it)
        }

        statAssetViewModel.getStatByClassroomNumber(classNumber!!)


        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button6.setOnClickListener{
            findNavController().navigate(R.id.action_classroomViewFragment_to_homeProfe)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}