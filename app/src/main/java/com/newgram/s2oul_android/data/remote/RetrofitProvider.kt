package com.newgram.s2oul_android.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitProvider {
    private const val BASE_URL = "https://"
    var api: S2oulAPI

    init {
        val retrofit = initRetrofit()
        api = retrofit.create()
    }

    fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}