package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.databinding.ScheduleItemBinding
import com.example.uniactivos.model.ScheduleDetails

class ScheduleAdapter : RecyclerView.Adapter<MainViewHolder3>(){

    private var schedule = mutableListOf<ScheduleDetails>()

    fun setScheduleList(schedule: List<ScheduleDetails>) {
        this.schedule = schedule.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder3 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ScheduleItemBinding.inflate(inflater, parent, false)

        return MainViewHolder3(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder3, position: Int) {
        val schedule = schedule[position]


    }

    override fun getItemCount(): Int {
        return schedule.size
    }

}

class MainViewHolder3(
    val binding: ScheduleItemBinding
) : RecyclerView.ViewHolder(binding.root)