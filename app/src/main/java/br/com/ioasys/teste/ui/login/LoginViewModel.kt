package br.com.ioasys.teste.ui.login

import androidx.lifecycle.ViewModel
import br.com.ioasys.teste.data.investor.Investor
import br.com.ioasys.teste.data.investor.InvestorRepository

class LoginViewModel(private val repository: InvestorRepository)
    : ViewModel() {

    // In the future, we may get investor data from auth call.
    suspend fun auth(investor: Investor) = repository.auth(investor).success
}
