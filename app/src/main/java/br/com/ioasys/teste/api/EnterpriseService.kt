package br.com.ioasys.teste.api

import br.com.ioasys.teste.data.auth.AuthResponse
import br.com.ioasys.teste.data.enterprise.Enterprise
import br.com.ioasys.teste.data.enterprise.EnterpriseList
import br.com.ioasys.teste.data.enterprise.EnterpriseShowResponse
import br.com.ioasys.teste.data.investor.Investor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface EnterpriseService {

    @POST("users/auth/sign_in")
    fun authAsync(@Body investor: Investor): Deferred<Response<AuthResponse>>

    @GET("enterprises")
    fun searchAsync(@Query("name") name: String?): Deferred<EnterpriseList>

    @GET("enterprises/{id}")
    fun showAsync(@Path("id") id: Int): Deferred<EnterpriseShowResponse>

    // A singleton object for Enterprise Retrofit service.
    companion object {
        private const val BASE_URL = "http://empresas.ioasys.com.br/api/v1/"
        val retrofit: EnterpriseService by lazy { create() }

        private fun create() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(EnterpriseInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(EnterpriseService::class.java)
    }
}