package com.pepecode.tmdbapp.api

import com.pepecode.tmdbapp.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TMDbApi by lazy {
        retrofit.create(TMDbApi::class.java)
    }
}