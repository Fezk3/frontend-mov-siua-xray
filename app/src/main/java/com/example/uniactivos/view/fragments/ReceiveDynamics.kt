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
import com.example.uniactivos.adapter.DynamicAssetAdapter
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.ScheduleAdapter
import com.example.uniactivos.databinding.FragmentReceiveDynamicsBinding
import com.example.uniactivos.repository.FormHistoryRepository
import com.example.uniactivos.service.FormHistoryService
import com.example.uniactivos.viewmodel.DynamicAssetViewModel
import com.example.uniactivos.viewmodel.FormHistoryFactory
import com.example.uniactivos.viewmodel.FormHistoryViewModel

class ReceiveDynamics : Fragment(){
    private var _binding: FragmentReceiveDynamicsBinding? = null
    private val binding get() = _binding!!

    private val dynAssetViewModel: DynamicAssetViewModel by viewModels()
    private val adapter: DynamicAssetAdapter = DynamicAssetAdapter()
    private lateinit var formHistoryViewModel: FormHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReceiveDynamicsBinding.inflate(inflater, container, false)
        val view = binding.root

        val classNumber = arguments?.getString(FormHistoryPendingAdapter.CLASSNUMBER)
        //val form = arguments?.getParcelable<FormHistoryDetails>(FORMHISTORY_OBJECT)

        binding.aulaTextView.text = classNumber

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

        val formHistoryService = FormHistoryService.getInstance()
        val formhistoryrepo = FormHistoryRepository(formHistoryService)

        formHistoryViewModel = ViewModelProvider(this, FormHistoryFactory(formhistoryrepo)).get(
            FormHistoryViewModel::class.java)


        binding.buttonAceptarActivos.setOnClickListener{
            findNavController().navigate(R.id.action_receiveDynamics3_to_receiveStatics2)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}