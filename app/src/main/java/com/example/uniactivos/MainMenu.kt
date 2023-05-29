package com.example.uniactivos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uniactivos.databinding.FragmentMainMenuBinding

class MainMenu : Fragment(){
    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardViewReportesGuardasPending.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_reports)
        }
        binding.cardViewAula.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_aulas)
        }
        binding.cardViewListaAulas.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenu2_to_aulas)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
