package com.newgram.s2oul_android.remote

import com.newgram.s2oul_android.entity.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface S2oulAPI {
    @GET("/detailInfo/show/{showId}")
    fun getShow(
        @Path("showId") showId: String
    ): Call<ShowDetailInfo>

    @GET("/detailInfo/theater/{theaterId}")
    fun getTheater(
        @Path("theaterId") theaterId: String
    ): Call<TheaterDetailInfo>

    @GET("/show/showList/?serachType={genre}&keyword={showName}")
    fun searchShow(
        @Path("genre") genre: String,
        @Path("showName") showName: String
    ): Call<Array<Show>>

    @GET("/theater/theaterList/?serachType={sort}&keyword={theaterName}")
    fun searchTheater(
        @Path("sort") genre: String,
        @Path("theaterName") theaterName: String
    ): Call<Array<TheaterInfo>>

    @GET("/Info/showEndDate/{genre}")
    fun showEndData(
        @Path("genre") genre: String
    ): Call<Array<ShowInfo>>

    @GET("/Info/showAlphabet/{genre}")
    fun showAlphabet(
        @Path("genre") genre: String
    ): Call<Array<ShowInfo>>

    @GET("/Info/theaterAlphabet/{genre}")
    fun showTheaterAlphabet(
        @Path("genre") genre: String
    ): Call<Array<TheaterInfo>>

    @GET("/map/{latAndLng}")
    fun getMap(
        @Path("latAndLng") latAndLng: String
    ): Call<Array<TheaterInfo>>
}