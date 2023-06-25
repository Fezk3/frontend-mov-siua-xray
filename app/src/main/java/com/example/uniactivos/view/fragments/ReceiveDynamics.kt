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
import com.example.uniactivos.adapter.DynamicAssetAdapter
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.ScheduleAdapter
import com.example.uniactivos.databinding.FragmentReceiveDynamicsBinding
import com.example.uniactivos.repository.DynamicAssetsRepository
import com.example.uniactivos.repository.FormHistoryRepository
import com.example.uniactivos.repository.MainRepository
import com.example.uniactivos.service.DynamicAssetService
import com.example.uniactivos.service.FormHistoryService
import com.example.uniactivos.service.MainService
import com.example.uniactivos.viewmodel.ClassroomViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModelFactory
import com.example.uniactivos.viewmodel.FormHistoryFactory
import com.example.uniactivos.viewmodel.FormHistoryViewModel
import com.example.uniactivos.viewmodel.ViewModelFactory
import okhttp3.internal.toLongOrDefault

class ReceiveDynamics : Fragment(){
    private var _binding: FragmentReceiveDynamicsBinding? = null
    private val binding get() = _binding!!

    private lateinit var dynAssetViewModel: DynamicAssetViewModel
    private val adapter: DynamicAssetAdapter = DynamicAssetAdapter()
    private lateinit var formHistoryViewModel: FormHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReceiveDynamicsBinding.inflate(inflater, container, false)
        val view = binding.root

        val formHisId = arguments?.getString(FormHistoryPendingAdapter.FORMHISTORY_ID)
        val classNumber = arguments?.getString(FormHistoryPendingAdapter.CLASSNUMBER)


        binding.aulaTextView.text = classNumber

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

        val formHistoryService = FormHistoryService.getInstance()
        val formhistoryrepo = FormHistoryRepository(formHistoryService)

        formHistoryViewModel = ViewModelProvider(this, FormHistoryFactory(formhistoryrepo)).get(FormHistoryViewModel::class.java)

        val formHistoryId = arguments?.getString(FormHistoryPendingAdapter.FORMHISTORY_ID)?.toLongOrNull()

        binding.buttonAceptarActivos.setOnClickListener{
            val classNumber = arguments?.getString(FormHistoryPendingAdapter.CLASSNUMBER)
            val bundle = bundleOf(CLASS_NUMBER to classNumber.toString())
            formHistoryViewModel.updateFormHistory(id = formHistoryId!!)
            findNavController().navigate(R.id.action_receiveDynamics3_to_receiveStatics2, bundle)
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