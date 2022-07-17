package com.example.kartrlanszckler.apiDataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SiralamaClass(
        val ID :Int?,
        val KullaniciID :Int?,
        val KullaniciAdi:String?,
        val Puan :Int?,
        val DogruSayisi :Int?,
        val YanlisSayisi :Int?,
        val SiralamaNo :Int?,
) : Parcelable