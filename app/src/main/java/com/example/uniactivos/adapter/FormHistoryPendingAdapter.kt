package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.R
import com.example.uniactivos.databinding.FormHistoryItemBinding
import com.example.uniactivos.databinding.PendingAssetsItemBinding
import com.example.uniactivos.model.FormHistoryDetails

class FormHistoryPendingAdapter : RecyclerView.Adapter<FormHistoryPendingViewHolder>() {

    var form = mutableListOf<FormHistoryDetails>()

    fun setFormList(form: List<FormHistoryDetails>) {
        this.form = form.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormHistoryPendingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PendingAssetsItemBinding.inflate(inflater, parent, false)

        return FormHistoryPendingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FormHistoryPendingViewHolder, position: Int) {
        val formr = form[position]
        holder.binding.classroom.text = formr.classroomNumber.toString()
        holder.binding.idForm.text = formr.formid.toString()
        holder.binding.professor.text = formr.userId?.toString()

        holder.binding.actionGiveAssets.setOnClickListener {
            val bundle = bundleOf(FORMHISTORY_ID to form[position].formid.toString(),
                CLASSNUMBER to form[position].classroomNumber.toString())
            it.findNavController().navigate(R.id.action_pendingAssets_to_receiveDynamics3, bundle)
            //it.findNavController().navigate(R.id.action_receiveDynamics3_to_receiveStatics2, bundle)
        }
    }

    override fun getItemCount(): Int {
        return form.size
    }

    companion object {
        const val FORMHISTORY_ID = "formHistory"
        const val CLASSNUMBER = "classNumber"
    }

//No se ocuparia esto porque no se necesita pasar informacion
//    companion object {
//        const val CLASSROOM_ID = "class_number"
//    }
}
class FormHistoryPendingViewHolder(
    val binding: PendingAssetsItemBinding
) : RecyclerView.ViewHolder(binding.root)