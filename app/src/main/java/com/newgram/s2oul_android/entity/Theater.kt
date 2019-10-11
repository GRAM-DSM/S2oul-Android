package com.newgram.s2oul_android.entity

data class Theater(
    var image: String,
    var name: String,
    var phoneNumber: String,
    var theaterId: String,
    var location: String,
    var seatNumber: String,
    var shows: Array<Show>
)