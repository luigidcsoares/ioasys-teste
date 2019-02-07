package br.com.ioasys.teste.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ioasys.teste.data.enterprise.EnterpriseRepository

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val repository: EnterpriseRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            DetailViewModel(repository) as T
}