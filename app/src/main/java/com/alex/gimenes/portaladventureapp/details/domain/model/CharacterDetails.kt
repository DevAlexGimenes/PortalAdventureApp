package com.alex.gimenes.portaladventureapp.details.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterDetails(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("status")
    val status: String = "",

    @SerializedName("image")
    val image: String = "",

    @SerializedName("species")
    val species: String = "",

    @SerializedName("gender")
    val gender: String = ""

) : Parcelable