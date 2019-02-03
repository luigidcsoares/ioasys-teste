package br.com.ioasys.teste.data

data class AuthResponse(
    val investor: Investor?,
    val success: Boolean = false
)