package com.minton.carwash.util

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitHelper {
    private const val BASE_URL = "http://"
    
    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("X-request-ID", "6ea05c85-04c4-470e-9532-12769d2e306c")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .build()
            it.proceed(request)
        }
        .addInterceptor(ResponseInterceptor()) // 응답 코드
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) // okhttp 로그
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

//    val loginApi: LoginApiService = retrofit.create(LoginApiService::class.java)
}

class ResponseInterceptor : Interceptor { // 예외 처리

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        when (response.code) {
            200 -> {
                Log.d("log", "로그인 성공 ${response.message}")
            }

            401 -> {
                Log.e("error", "인증 실패 ${response.message}")
            }

            404 -> {
                Log.e("error", "요청 유저가 없음 ${response.message}")
            }

            409 -> {
                Log.e("error", "중복된 데이터 ${response.message}")
            }

            422 -> {
                Log.e("error", "요청 파라미터 확인 ${response.message}")
            }

            502 -> {
                Log.e("error", "문자 발송 실패 ${response.message}")
            }
        }
        return response
    }
}