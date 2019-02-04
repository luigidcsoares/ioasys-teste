package br.com.ioasys.teste.data.enterprise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ioasys.teste.api.EnterpriseService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EnterpriseRepository {
    fun search(name: String): LiveData<EnterpriseList> {
        val service = EnterpriseService.retrofit
        val call = service.search(name)

        val enterpriseList = MutableLiveData<EnterpriseList>()

        call.enqueue(object: Callback<EnterpriseList> {
            override fun onFailure(call: Call<EnterpriseList>, t: Throwable) { }

            override fun onResponse(call: Call<EnterpriseList>, response: Response<EnterpriseList>) {
                enterpriseList.value = response.body()
            }
        })

        return enterpriseList
    }
}