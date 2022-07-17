package com.example.kartrlanszckler.apiDataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class KelimelerClass(
    val KelimeID :Int?,
    val KelimeninDogrusu :String?,
    val KelimeninYanlisi :String?
) :Parcelable