package br.com.ioasys.teste.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.teste.data.enterprise.EnterpriseList
import br.com.ioasys.teste.data.enterprise.EnterpriseRepository

class HomeViewModel(private val repository: EnterpriseRepository)
    : ViewModel() {

    val enterprises by lazy { MutableLiveData<EnterpriseList>() }

    suspend fun search(name: String?) { enterprises.value = repository.search(name).value }
}
