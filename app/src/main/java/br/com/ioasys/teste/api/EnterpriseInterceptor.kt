package br.com.ioasys.teste.api

import okhttp3.Interceptor
import okhttp3.Response

object EnterpriseInterceptor : Interceptor {

    var accessToken: String? = null
    var client: String? = null
    var uid: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        // Add headers if they're null.
        request.header("access-token") ?: accessToken?.let { builder.header("access-token", it) }
        request.header("client") ?: client?.let { builder.header("client", it) }
        request.header("uid") ?: uid?.let { builder.header("uid", it) }

        return chain.proceed(builder.build())
    }
}