package br.com.ioasys.teste.ui.detail

import androidx.lifecycle.ViewModel
import br.com.ioasys.teste.data.enterprise.Enterprise
import br.com.ioasys.teste.data.enterprise.EnterpriseRepository

class DetailViewModel(private val repository: EnterpriseRepository) : ViewModel() {

    suspend fun show(id: Int): Enterprise = repository.show(id)

}
