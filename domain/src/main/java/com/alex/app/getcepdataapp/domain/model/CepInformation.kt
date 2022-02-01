package com.alex.app.getcepdataapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CepInformation(

    @SerializedName("cep")
    val cep: String? = "",

    @SerializedName("logradouro")
    val street: String? = "",

    @SerializedName("complemento")
    val complement: String? = "",

    @SerializedName("bairro")
    val district: String? = "",

    @SerializedName("localidade")
    val location: String? = "",

    @SerializedName("uf")
    val city: String? = "",

    @SerializedName("ddd")
    val ddd: String? = "",

    ) : Parcelable

