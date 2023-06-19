package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.R
import com.example.uniactivos.databinding.AulaItemBinding
import com.example.uniactivos.model.Classroom
import com.example.uniactivos.view.fragments.AulasDirections


class ClassroomAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var classroom = mutableListOf<Classroom>()

    fun setClassroomList(classroom: List<Classroom>) {
        this.classroom = classroom.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AulaItemBinding.inflate(inflater, parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val classr = classroom[position]
        holder.binding.Numero.text = classr.classNumber.toString()

        holder.itemView.setOnClickListener {
            val bundle = bundleOf(CLASSROOM_ID to classroom[position].classNumber.toString())
            it.findNavController().navigate(R.id.action_aulas_to_classroomViewFragment, bundle)
        }

    }

    override fun getItemCount(): Int {
        return classroom.size
    }

    companion object {
        const val CLASSROOM_ID = "class_id"
    }

}

class MainViewHolder(
    val binding: AulaItemBinding
) : RecyclerView.ViewHolder(binding.root)

