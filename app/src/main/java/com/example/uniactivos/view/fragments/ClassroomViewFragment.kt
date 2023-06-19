package com.example.uniactivos.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uniactivos.adapter.ClassroomAdapter.Companion.CLASSROOM_ID
import com.example.uniactivos.databinding.FragmentClassroomViewBinding
import com.example.uniactivos.viewmodel.ClassroomViewModel

class ClassroomViewFragment : Fragment(){
    private var _binding: FragmentClassroomViewBinding? = null
    private val binding get() = _binding!!
    private val classroomViewModel: ClassroomViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClassroomViewBinding.inflate(inflater, container, false)
        val view = binding.root

        val classNumber = arguments?.getString(CLASSROOM_ID)
        binding.titleaula.text = classNumber


        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}