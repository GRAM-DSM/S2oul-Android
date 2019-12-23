package com.newgram.s2oul_android.entity

data class TheaterDetail(
    var theaterId: String,
    var theaterImage: String,
    var theaterName: String,
    var phoneNumber: String,
    var location: String,
    var seatNumber: Int,
    var shows: ArrayList<Show>
)