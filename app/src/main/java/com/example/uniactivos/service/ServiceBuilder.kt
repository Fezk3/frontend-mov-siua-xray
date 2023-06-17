package com.example.uniactivos.service

import com.example.uniactivos.BuildConfig
import com.example.uniactivos.utils.AuthorizationInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val client =
        OkHttpClient.Builder().addInterceptor(AuthorizationInterceptor()).build()
    private val Base_URL = "https://uniactivosxray-app-v01.herokuapp.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(Base_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}