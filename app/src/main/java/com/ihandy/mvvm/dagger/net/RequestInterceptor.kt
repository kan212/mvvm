package com.ihandy.mvvm.dagger.net

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor() :Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain!!.request()
        val originalHttpUrl: HttpUrl = original.url()
        val url: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("拦截器","测试")
            .build()

        val request: Request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}