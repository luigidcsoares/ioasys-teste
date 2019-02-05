package br.com.ioasys.teste.data.enterprise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ioasys.teste.api.EnterpriseService

object EnterpriseRepository {

    suspend fun search(name: String?): LiveData<EnterpriseList> =
            EnterpriseService.retrofit.searchAsync(name).await().let {
                MutableLiveData<EnterpriseList>().apply { value = it }
            }
}