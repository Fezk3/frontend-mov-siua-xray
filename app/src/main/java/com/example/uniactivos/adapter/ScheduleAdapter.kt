package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.R
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
        val schedulee = schedule[position]

        holder.binding.aula.text = schedulee.classroom?.classNumber.toString()
        holder.binding.curso.text = schedulee.courseName.toString()
        holder.binding.horaini.text = schedulee.startTime.toString()
        holder.binding.horafin.text = schedulee.endTime.toString()

        holder.binding.action.setOnClickListener {

            val bundle = bundleOf(SCHEDULE_CLASS to schedule[position].classroom?.classNumber.toString())

            it.findNavController().navigate(R.id.action_mySchedule2_to_teacherDynamicForm, bundle)
        }

    }

    override fun getItemCount(): Int {
        return schedule.size
    }

    companion object {
        const val SCHEDULE_CLASS = "classroom"
    }

}

class MainViewHolder3(
    val binding: ScheduleItemBinding
) : RecyclerView.ViewHolder(binding.root)