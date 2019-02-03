package br.com.ioasys.teste.data.enterprise

import com.google.gson.annotations.SerializedName

data class Enterprise(
    val id: Int = -1,
    val description: String,
    val city: String,
    val country: String,
    @SerializedName("enterprise_name") val name: String
)