package com.example.uniactivos.model

data class ClassroomDetails(
    var id: Long? = null,
    var classNumber: String? = null,
    var college: CollegeDetails? = null,
    var assetsList: List<AssetsDetails>? = null,
)
data class AssetsDetails(
    var id: Long? = null,
    var name: String? = null,
    var assetType: AssetTypeDetails? = null,
)
data class AssetTypeDetails(
    var id: Long? = null,
    var description: String? = null,
)
