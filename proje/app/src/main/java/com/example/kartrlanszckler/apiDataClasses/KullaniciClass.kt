package com.example.kartrlanszckler.apiDataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class KullaniciClass(
        val KullanicininIDsi :Int,
        val Ad :String?,
        val Sifre :String?
) :Parcelable
