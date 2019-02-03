package br.com.ioasys.teste.api

import okhttp3.Interceptor
import okhttp3.Response

object EnterpriseInterceptor : Interceptor {

    var accessToken: String? = null
    var client: String? = null
    var uid: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        // Add headers if they're not null.
        accessToken?.let { builder.header("access-token", it) }
        client?.let { builder.header("client", it) }
        uid?.let { builder.header("uid", it) }

        return chain.proceed(builder.build())
    }
}