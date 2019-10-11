package com.newgram.s2oul_android.remote

import com.newgram.s2oul_android.entity.Show
import com.newgram.s2oul_android.entity.Theater
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface S2oulAPI {
    @GET("/detailInfo/show/{showId}")
    fun getShow(
        @Path("showId") showId: String
    ): Call<Show>

    @GET("/detailInfo/theater/{theaterId}")
    fun getTheater(
        @Path("theaterId") theaterId: String
    ): Call<Theater>

    @GET("/searchShow/{genre}")
    fun searchShow(
        @Path("genre") genre: String
    ): Call<Array<Show>>

    @GET("/searchTheater/{genre}")
    fun searchTheater(
        @Path("genre") genre: String
    ): Call<Array<Theater>>
}