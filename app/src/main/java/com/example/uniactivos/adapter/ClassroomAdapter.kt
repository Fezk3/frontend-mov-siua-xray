package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.databinding.AulaItemBinding
import com.example.uniactivos.model.ClassroomDetails

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

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val classr = classroom[position]
        holder.binding.Numero.text = classr.classNumber.toString()
        holder.binding.btnViewDetails.setOnClickListener {


        }
    }

    override fun getItemCount(): Int {
        return classroom.size
    }

}

class MainViewHolder(
    val binding: AulaItemBinding
) : RecyclerView.ViewHolder(binding.root)