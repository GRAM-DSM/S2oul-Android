package com.newgram.s2oul_android.data.remote

import com.newgram.s2oul_android.entity.*
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("/Info/theaterAlphabet")
    fun showTheaterAlphabet(): Flowable<ArrayList<TheaterInfo>>

    //Map
    @GET("/map/{latAndLng}")
    fun getMap(
        @Path("latAndLng") latAndLng: String
    ): Call<Array<TheaterMap>>

    //Search
    @GET("/show/showList/")
    fun searchShow(
        @Query("searchType") genre: String,
        @Query("searchType") sort: String,
        @Query("keyword") showName: String
    ): Flowable<ArrayList<ShowResult>>

    @GET("/theater/theaterList")
    fun searchTheater(
        @Query("keyword") theaterName: String
    ): Flowable<ArrayList<TheaterResult>>
}