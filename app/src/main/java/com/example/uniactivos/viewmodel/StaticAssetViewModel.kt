package com.example.uniactivos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniactivos.model.AssetsDetails
import com.example.uniactivos.model.providers.StaticAssetProvider

class StaticAssetViewModel : ViewModel(){
    val assetDetail =  MutableLiveData<AssetsDetails>()
    val assetDetailList = MutableLiveData<List<AssetsDetails>>()

    fun getStatAsset() {
        val position = (0..2).random()
        val _assetDetail = StaticAssetProvider.findById(position)
        assetDetail.postValue(_assetDetail)
    }

    fun findAllStatAssets() {
        val _assetDetailList = StaticAssetProvider.findAllAssets()
        assetDetailList.postValue(_assetDetailList)
    }
}