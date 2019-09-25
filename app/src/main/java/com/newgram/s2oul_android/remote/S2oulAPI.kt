package com.newgram.s2oul_android.remote

import com.newgram.s2oul_android.entities.Theater
import retrofit2.Call
import retrofit2.http.GET

interface S2oulAPI {
    @GET("/theater")
    fun getTheater(): Call<Theater>
}