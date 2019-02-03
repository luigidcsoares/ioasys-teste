package br.com.ioasys.teste.data.auth

import br.com.ioasys.teste.data.investor.Investor

data class AuthResponse(
    val investor: Investor?,
    val success: Boolean = false
)