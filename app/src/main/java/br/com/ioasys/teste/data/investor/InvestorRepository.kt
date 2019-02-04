package br.com.ioasys.teste.data.investor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ioasys.teste.api.EnterpriseInterceptor
import br.com.ioasys.teste.api.EnterpriseService
import br.com.ioasys.teste.data.auth.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object InvestorRepository {

    fun auth(investor: Investor): LiveData<AuthResponse> {
        val service = EnterpriseService.retrofit
        val call = service.auth(investor)

        val authResponse = MutableLiveData<AuthResponse>()

        call.enqueue(object: Callback<AuthResponse> {
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) { }

            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                authResponse.value = response.body() ?: AuthResponse(
                    null,
                    response.isSuccessful
                )

                // If it was successful, add custom headers to subsequent requests.
                if (response.isSuccessful) {
                    EnterpriseInterceptor.accessToken = response.headers().get("access-token")
                    EnterpriseInterceptor.client = response.headers().get("client")
                    EnterpriseInterceptor.uid = response.headers().get("uid")
                }
            }
        })

        return authResponse
    }
}