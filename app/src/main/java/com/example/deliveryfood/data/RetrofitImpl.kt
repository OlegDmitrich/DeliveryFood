package com.example.deliveryfood.data

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl {

    private val baseurl = "https://burgers1.p.rapidapi.com/burgers/"

    fun getRetrofitImpl(): BurgerApi {
        val podRetrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(createOkHttpClint(PODInterceptor()))
            .build()
        return podRetrofit.create(BurgerApi::class.java)
    }

    private fun createOkHttpClint(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        return httpClient.build()
    }

    inner class PODInterceptor: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(chain.request())
        }

    }
}