package com.newgram.s2oul_android.data.source

import com.newgram.s2oul_android.entity.TheaterDetail
import io.reactivex.Flowable

interface PlaceDetailSource {

    fun loadPlace(theaterId: String): Flowable<TheaterDetail>
}