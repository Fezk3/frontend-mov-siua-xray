package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.databinding.StaticAssetItemBinding
import com.example.uniactivos.model.AssetsDetails

class StaticAssetAdapter : RecyclerView.Adapter<StaticViewHolder>() {

    var assets = mutableListOf<AssetsDetails>()

    fun setAssetList(assets: List<AssetsDetails>) {
        this.assets = assets.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, MainviewType: Int): StaticViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StaticAssetItemBinding.inflate(inflater, parent, false)

        return StaticViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StaticViewHolder, position: Int) {
        val asset = assets[position]
        holder.binding.StatAssetName.text = asset.name
        holder.binding.StatAssetCant.text = asset.cant.toString()
    }

    override fun getItemCount(): Int {
        return assets.size
    }
}

class StaticViewHolder(
    val binding: StaticAssetItemBinding
) : RecyclerView.ViewHolder(binding.root)