package com.example.baselib.https

import com.example.baselib.constant.HttpsConstant
import com.example.baselib.constant.GlobalConstant
import com.example.baselib.constant.HttpsConstant.TIME_OUT_SECONDS
import com.example.baselib.utils.GsonUtil
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLDecoder
import java.util.concurrent.TimeUnit

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
object RetrofitManager {
    private val logging = HttpLoggingInterceptor().apply {
        level =
            if (GlobalConstant.PRINGT_LOG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    }

    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(headersInterceptor)
            .addInterceptor(logging)
            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .build()

    fun <T> getService(serviceClass: Class<T>): T {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(HttpsConstant.BASE_URL)
            .build()
            .create(serviceClass)
    }

    private val headersInterceptor: Interceptor = Interceptor { chain ->
        val oldRequest = chain.request()
        val newRequestBuild = oldRequest.newBuilder()
        val headerParams = headerParams()
        for ((keyName, valueParm) in headerParams) {
            newRequestBuild.header(keyName, valueParm.toString())
        }

        if ("POST".equals(oldRequest.method, ignoreCase = true)) {
            val oldBody = oldRequest.body
            if (oldBody is FormBody) {
                newRequestBuild.post(
                    URLDecoder.decode(requestParam(oldBody), HttpsConstant.URL_Decode_UTF_8)
                        .toRequestBody(HttpsConstant.CONTENT_TYPE)
                )
            }
        }

        chain.proceed(newRequestBuild.build())
    }

    private fun requestParam(oldBody: FormBody): String {
        val hashMap = mutableMapOf<String, String?>()
        for (index in 0 until oldBody.size) {
            hashMap[oldBody.encodedName(index)] = oldBody.encodedValue(index)
        }
        return GsonUtil.toJson(hashMap)
    }

    private fun headerParams(): MutableMap<String, Any?> {

        return mutableMapOf(
            "token" to "",//(tk)token
            "sv" to "15",//(sv)操作系统版本号
            "versionName" to "1.0.0",//app版本号名称
            "versionCode" to 1,//(avn)app版本名称
        )
    }

}