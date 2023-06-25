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
import com.example.uniactivos.databinding.FragmentReceiveStaticsBinding
import com.example.uniactivos.repository.DynamicAssetsRepository
import com.example.uniactivos.repository.StaticAssetRepository
import com.example.uniactivos.service.DynamicAssetService
import com.example.uniactivos.service.StaticAssetService
import com.example.uniactivos.viewmodel.DynamicAssetViewModel
import com.example.uniactivos.viewmodel.DynamicAssetViewModelFactory
import com.example.uniactivos.viewmodel.StaticAssetViewModel
import com.example.uniactivos.viewmodel.StaticAssetViewModelFactory
import okhttp3.internal.toLongOrDefault

class ReceiveStatics : Fragment(){
    private var _binding: FragmentReceiveStaticsBinding? = null
    private val binding get() = _binding!!

    private lateinit var statAssetViewModel: StaticAssetViewModel
    private val adapter: StaticAssetAdapter = StaticAssetAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReceiveStaticsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvStaticAsset.layoutManager = LinearLayoutManager(requireContext())
        binding.rvStaticAsset.adapter = adapter

        val classNumber = arguments?.getString(FormHistoryPendingAdapter.CLASSNUMBER)

        val statAssetService = StaticAssetService.getInstance()
        val statAssetRepo = StaticAssetRepository(statAssetService)

        statAssetViewModel = ViewModelProvider(this, StaticAssetViewModelFactory(statAssetRepo)).get(
            StaticAssetViewModel::class.java)

        statAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapter.setAssetList(it)
        }

        statAssetViewModel.getStatByClassroomNumber(classNumber!!)
        //statAssetViewModel.findAllStatAssets()

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAceptarActivos.setOnClickListener{
            findNavController().navigate(R.id.action_receiveStatics2_to_homeGuarda)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}