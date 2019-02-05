package br.com.ioasys.teste.ui.home

import androidx.lifecycle.ViewModel
import br.com.ioasys.teste.data.enterprise.EnterpriseRepository

class HomeViewModel(private val enterpriseRepository: EnterpriseRepository)
    : ViewModel() {

    suspend fun search(name: String?) = enterpriseRepository.search(name).value
}
