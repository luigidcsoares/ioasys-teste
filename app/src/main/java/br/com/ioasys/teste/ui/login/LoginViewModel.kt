package br.com.ioasys.teste.ui.login

import androidx.lifecycle.ViewModel
import br.com.ioasys.teste.data.auth.AuthRequest
import br.com.ioasys.teste.data.investor.InvestorRepository

class LoginViewModel(private val investorRepository: InvestorRepository)
    : ViewModel() {

    fun auth(authRequest: AuthRequest) = investorRepository.auth(authRequest)
}
