package br.com.ioasys.teste.data.enterprise

import com.google.gson.annotations.SerializedName

data class Enterprise(
    val id: Int,
    val description: String,
    val country: String,
    @SerializedName("enterprise_name") val name: String,
    @SerializedName("enterprise_type") val type: EnterpriseType
)

data class EnterpriseType(
    val id: Int,
    @SerializedName("enterprise_type_name") val name: String
)