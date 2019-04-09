package com.wd.tech.mypush.kotlin


import com.wd.tech.mypushs.BuildConfig
import com.wd.tech.mypushs.net.AppInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit
import kotlin.reflect.KProperty

class RetrofitUtil private constructor() {

    lateinit var retrofit: Retrofit

    companion object {
        val instance: RetrofitUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitUtil()
        }
    }

    fun init(string: String) {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))

             //   .addNetworkInterceptor(AppInterceptor())
                //.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(BaseApi.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

    }

    fun <T> getSerive(sclass: Class<T>): T {

        return retrofit.create(sclass)
    }
}



