package com.neisha.catapps

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cat(
    var name: String,
    var description: String,
    var photo: String
) : Parcelable

