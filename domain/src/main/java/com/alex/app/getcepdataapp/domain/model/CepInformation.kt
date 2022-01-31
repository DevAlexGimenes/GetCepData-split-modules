package com.alex.app.getcepdataapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CepInformation(

    @SerializedName("cep")
    val cep: String? = ""

) : Parcelable

