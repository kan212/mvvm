package com.ihandy.mvvm.dagger.module

import com.ihandy.mvvm.BuildConfig
import com.ihandy.mvvm.dagger.net.NetService
import com.ihandy.mvvm.dagger.net.RequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * 测试的网络提供出去的基本模块
 */
@Module
class RetrofitModule {

    /**
     * 用第三方的一个网络来进行测试
     */
    companion object {
        private const val CONNECT_TIMEOUT_IN_MS: Long = 30 * 1000
        private const val BASE_URL = "https://www.wanandroid.com/"
    }

    @Singleton
    @Provides
    fun providerRequestInterceptor(requestInterceptor: RequestInterceptor): Interceptor =
        requestInterceptor

    @Singleton
    @Provides
    fun provideOkHttpClient(requestInterceptor: RequestInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(CONNECT_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun providerConverterFactory(): Converter.Factory {
        if (BuildConfig.DEBUG) {
            return GsonConverterFactory.create()
        }
        return MoshiConverterFactory.create()
    }


    @Singleton
    @Provides
    fun providerCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        factory: CallAdapter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(factory)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): NetService = retrofit.create(NetService::class.java)

}