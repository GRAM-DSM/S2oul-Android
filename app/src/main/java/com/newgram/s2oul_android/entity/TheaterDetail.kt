package com.newgram.s2oul_android.entity

data class TheaterDetail(
    var theaterId: String,
    var image: String,
    var name: String,
    var phoneNumber: String,
    var location: String,
    var seatNumber: String,
    var shows: ArrayList<Show>
)