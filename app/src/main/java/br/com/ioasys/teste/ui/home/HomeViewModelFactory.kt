package br.com.ioasys.teste.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ioasys.teste.data.enterprise.EnterpriseRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val enterpriseRepository: EnterpriseRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            HomeViewModel(enterpriseRepository) as T
}