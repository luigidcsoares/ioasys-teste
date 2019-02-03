package br.com.ioasys.teste.data

import com.google.gson.annotations.SerializedName

data class Enterprise(
    val id: Int = -1,
    @SerializedName("enterprise_name") val name: String,
    val description: String,
    val city: String,
    val country: String
)