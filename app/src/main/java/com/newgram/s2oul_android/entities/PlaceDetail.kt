package com.newgram.s2oul_android.entities

data class PlaceDetail(
    var name: String,
    var number: String,
    var address: String,
    var sitCount: String,
    var shows: List<Showing>
) {}