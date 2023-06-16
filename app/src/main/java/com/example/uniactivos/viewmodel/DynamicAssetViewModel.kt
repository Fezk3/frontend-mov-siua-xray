package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.AssetTypeDetails
import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.providers.DynamicAssetProvider

class DynamicAssetViewModel : ViewModel(){
    val assetDetail =  MutableLiveData<AssetsDetails>()
    val assetDetailList = MutableLiveData<List<AssetsDetails>>()

    fun getDinAsset() {
        val position = (0..2).random()
        val _assetDetail = DynamicAssetProvider.findById(position)
        assetDetail.postValue(_assetDetail)
    }

    fun findAllDinAssets() {
        val _assetDetailList = DynamicAssetProvider.findAllAssets()
        assetDetailList.postValue(_assetDetailList)
    }
}