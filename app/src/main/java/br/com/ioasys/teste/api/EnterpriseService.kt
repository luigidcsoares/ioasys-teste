package br.com.ioasys.teste.api

import br.com.ioasys.teste.data.AuthRequest
import br.com.ioasys.teste.data.AuthResponse
import br.com.ioasys.teste.data.Enterprise
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EnterpriseService {

    @POST("users/auth/sign_in")
    fun auth(@Body authRequest: AuthRequest): Call<AuthResponse>

    @GET("enterprises")
    fun enterprises(@Query("name") name: String): Call<List<Enterprise>>

    // A singleton object for Enterprise Retrofit service
    companion object {
        @Volatile private var instance: EnterpriseService? = null
        private const val BASE_URL = "http://empresas.ioasys.com.br/api/v1/"

        fun getInstance(): EnterpriseService = instance ?: synchronized(this) {
            instance ?: build().create(EnterpriseService::class.java).also { instance = it }
        }

        private fun build() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(EnterpriseInterceptor).build())
            .build()
    }
}