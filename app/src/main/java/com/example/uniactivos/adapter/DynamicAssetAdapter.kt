package com.example.uniactivos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.uniactivos.databinding.DynamicAssetItemBinding
import com.example.uniactivos.model.AssetsDetails

class DynamicAssetAdapter : RecyclerView.Adapter<ViewHolder>() {

        var assets = mutableListOf<AssetsDetails>()

        fun setAssetList(assets: List<AssetsDetails>) {
            this.assets = assets.toMutableList()
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = DynamicAssetItemBinding.inflate(inflater, parent, false)

            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val asset = assets[position]
            holder.binding.dynAssetName.text = asset.name
            holder.binding.dynAssetCant.text = asset.cant.toString()
        }

        override fun getItemCount(): Int {
            return assets.size
        }
    }

    class ViewHolder(
        val binding: DynamicAssetItemBinding
    ) : RecyclerView.ViewHolder(binding.root)