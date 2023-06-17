package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.databinding.AulaItemBinding
import com.example.uniactivos.model.ClassroomDetails
import com.example.uniactivos.view.fragments.AulasDirections


class ClassroomAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var classroom = mutableListOf<ClassroomDetails>()

    fun setClassroomList(classroom: List<ClassroomDetails>) {
        this.classroom = classroom.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AulaItemBinding.inflate(inflater, parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int, model: ClassroomDetails) {
        val classr1 = classroom[position].id
        val classr = classroom[position]
        holder.binding.Numero.text = classr.classNumber.toString()
        // enviar datos al fragment
        holder.binding.btnViewDetails.setOnClickListener {
            val action = AulasDirections.actionAulasToClassroomViewFragment(classr1)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return classroom.size
    }

}

class MainViewHolder(
    val binding: AulaItemBinding
) : RecyclerView.ViewHolder(binding.root)

interface ClassroomItemClickListener {
    fun onClassroomItemClick(classroom: ClassroomDetails)
}