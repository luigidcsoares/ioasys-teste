package br.com.ioasys.teste.data

import br.com.ioasys.teste.api.EnterpriseService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EnterpriseRepository {
    fun enterprises(name: String) {
        val service = EnterpriseService.getInstance()
        val call = service.enterprises(name)

        call.enqueue(object: Callback<EnterpriseList> {
            override fun onFailure(call: Call<EnterpriseList>, t: Throwable) {
                android.util.Log.e("SearchError", t.localizedMessage)
            }

            override fun onResponse(call: Call<EnterpriseList>, response: Response<EnterpriseList>) {
                android.util.Log.i("TESTESEARCH", response.body().toString())
                android.util.Log.i("TESTESEARCH", response.headers().toString())
            }
        })
    }
}