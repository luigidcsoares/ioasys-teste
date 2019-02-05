package br.com.ioasys.teste.data.auth

import br.com.ioasys.teste.data.enterprise.Enterprise
import br.com.ioasys.teste.data.investor.Investor

data class AuthResponse(
    val investor: Investor? = null,
    val success: Boolean = false,
    val enterprise: Enterprise? = null
)