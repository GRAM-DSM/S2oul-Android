package com.newgram.s2oul_android.entity

data class ShowDetail(
    var name: String,
    var age: String,
    var price: String,
    var place: PlaceDetail,
    var story: List<String>
) {}