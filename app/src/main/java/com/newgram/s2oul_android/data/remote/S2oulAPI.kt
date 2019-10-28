package com.newgram.s2oul_android.data.remote

import com.newgram.s2oul_android.entity.*
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface S2oulAPI {
    //DetailInfo
    @GET("/detailInfo/show/{showId}")
    fun getShow(
        @Path("showId") showId: String
    ): Flowable<ShowDetail>

    @GET("/detailInfo/theater/{theaterId}")
    fun getTheater(
        @Path("theaterId") theaterId: String
    ): Flowable<TheaterDetail>

    //Info
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

    //Map
    @GET("/map/{latAndLng}")
    fun getMap(
        @Path("latAndLng") latAndLng: String
    ): Call<Array<TheaterMap>>

    //Search
    @GET("/show/showList/?searchType={genre}&keyword={showName}")
    fun searchShow(
        @Path("genre") genre: String,
        @Path("showName") showName: String
    ): Call<Array<ShowResult>>

    @GET("/theater/theaterList?keyword={theaterName}")
    fun searchTheater(
        @Path("sort") genre: String,
        @Path("theaterName") theaterName: String
    ): Call<Array<TheaterResult>>
}