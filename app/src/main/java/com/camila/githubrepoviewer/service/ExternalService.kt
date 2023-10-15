package com.camila.githubrepoviewer.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ExternalService {
    private const val BASE_URL = "https://api.github.com/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}