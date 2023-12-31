package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.databinding.FormHistoryItemBinding
import com.example.uniactivos.databinding.FormhisItemBinding
import com.example.uniactivos.model.FormHistoryDetails

class FormHistoryAdapter : RecyclerView.Adapter<MainViewHolder2>() {

    var form = mutableListOf<FormHistoryDetails>()

    fun setFormList(form: List<FormHistoryDetails>) {
        this.form = form.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder2 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FormHistoryItemBinding.inflate(inflater, parent, false)

        return MainViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder2, position: Int) {
        val formr = form[position]
        holder.binding.id.text = formr.formid.toString()
        holder.binding.formid.text = formr.id?.toString()
        holder.binding.user.text = formr.userId?.toString()
        holder.binding.date.text = formr.date.toString()
        holder.binding.state.text = formr.state
    }

    override fun getItemCount(): Int {
        return form.size
    }
//No se ocuparia esto porque no se necesita pasar informacion
//    companion object {
//        const val CLASSROOM_ID = "class_number"
//    }
}
class MainViewHolder2(
    val binding: FormHistoryItemBinding
) : RecyclerView.ViewHolder(binding.root)