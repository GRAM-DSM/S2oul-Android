package com.newgram.s2oul_android.entity

data class TheaterDetailInfo(
    var image: String,
    var name: String,
    var phoneNumber: String,
    var location: String,
    var seatNumber: String,
    var shows: Array<Show>
)