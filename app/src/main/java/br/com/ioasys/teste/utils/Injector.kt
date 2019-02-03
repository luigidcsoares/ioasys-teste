package br.com.ioasys.teste.utils

import br.com.ioasys.teste.data.investor.InvestorRepository
import br.com.ioasys.teste.ui.login.LoginViewModelFactory

object Injector {
    fun provideLoginViewModelFactory(): LoginViewModelFactory =
            LoginViewModelFactory(InvestorRepository)
}