package com.example.uniactivos.model

import android.os.Parcel
import android.os.Parcelable

data class ClassroomDetails(
    var id: Long? = null,
    var classNumber: String? = null,
    var college: College? = null,
    var assetsList: List<AssetsDetails>? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Long::class.java.classLoader) as Long?,
        parcel.readString(),
        parcel.readParcelable(College::class.java.classLoader),
        parcel.createTypedArrayList(AssetsDetails.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(classNumber)
        parcel.writeParcelable(college, flags)
        parcel.writeTypedList(assetsList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ClassroomDetails> {
        override fun createFromParcel(parcel: Parcel): ClassroomDetails {
            return ClassroomDetails(parcel)
        }

        override fun newArray(size: Int): Array<ClassroomDetails?> {
            return arrayOfNulls(size)
        }
    }
}

data class AssetsDetails(
    var id: Long? = null,
    var name: String? = null,
    var cant: Long? = null,
    var assetType: AssetTypeDetails? = null,
)
data class AssetTypeDetails(
    var id: Long? = null,
    var description: String? = null,
)
