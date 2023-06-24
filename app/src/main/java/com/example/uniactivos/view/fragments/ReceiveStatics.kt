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
import com.example.uniactivos.adapter.FormHistoryPendingAdapter
import com.example.uniactivos.adapter.StaticAssetAdapter
import com.example.uniactivos.databinding.FragmentReceiveStaticsBinding
import com.example.uniactivos.viewmodel.StaticAssetViewModel

class ReceiveStatics : Fragment(){
    private var _binding: FragmentReceiveStaticsBinding? = null
    private val binding get() = _binding!!

    private val statAssetViewModel: StaticAssetViewModel by viewModels()
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
        //val form = arguments?.getParcelable<FormHistoryDetails>(FORMHISTORY_OBJECT)

        //binding.aula.text = classNumber

        statAssetViewModel.assetDetailList.observe(viewLifecycleOwner) {
            adapter.setAssetList(it)
        }

        statAssetViewModel.findAllStatAssets()

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