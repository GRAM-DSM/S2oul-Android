package com.newgram.s2oul_android.entities

data class ShowDetail(
    var name: String,
    var age: String,
    var price: String,
    var place: PlaceDetail,
    var story: List<String>
) {}