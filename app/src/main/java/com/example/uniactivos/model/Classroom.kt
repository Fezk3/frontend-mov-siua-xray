package com.example.uniactivos.model

import android.os.Parcel
import android.os.Parcelable

data class Classroom(
    var id: Long? = null,
    var classNumber: String? = null,
    var college: College? = null,
    var assetsList: List<AssetsDetails>? = null
)

data class AssetsDetails(
    var id: Long? = null,
    var name: String? = null,
    var quantity: Int? = null,
    var assetType: AssetTypeDetails? = null,
)
data class AssetTypeDetails(
    var id: Long? = null,
    var description: String? = null,
)
