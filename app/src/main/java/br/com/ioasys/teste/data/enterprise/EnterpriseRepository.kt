package br.com.ioasys.teste.data.enterprise

import br.com.ioasys.teste.api.EnterpriseService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EnterpriseRepository {
    fun search(name: String) {
        val service = EnterpriseService.retrofit
        val call = service.search(name)

        call.enqueue(object: Callback<EnterpriseList> {
            override fun onFailure(call: Call<EnterpriseList>, t: Throwable) { }

            override fun onResponse(call: Call<EnterpriseList>, response: Response<EnterpriseList>) {
                android.util.Log.i("TESTESEARCH", response.body().toString())
                android.util.Log.i("TESTESEARCH", response.headers().toString())
            }
        })
    }
}