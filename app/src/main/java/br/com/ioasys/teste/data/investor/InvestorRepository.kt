package br.com.ioasys.teste.data.investor

import br.com.ioasys.teste.api.EnterpriseInterceptor
import br.com.ioasys.teste.api.EnterpriseService
import br.com.ioasys.teste.data.auth.AuthResponse

object InvestorRepository {

    suspend fun auth(investor: Investor): AuthResponse =
        EnterpriseService.retrofit.authAsync(investor).await().let {
            if (it.isSuccessful) {
                EnterpriseInterceptor.accessToken = it.headers().get("access-token")
                EnterpriseInterceptor.client = it.headers().get("client")
                EnterpriseInterceptor.uid = it.headers().get("uid")
            }

            // If body isn't null login request was authorized, else we return an AuthResponse with
            // nullable fields and success being false.
            it.body() ?: AuthResponse()
        }
}