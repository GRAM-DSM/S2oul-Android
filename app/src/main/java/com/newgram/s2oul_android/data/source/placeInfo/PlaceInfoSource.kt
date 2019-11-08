package com.newgram.s2oul_android.data.source.placeInfo

import com.newgram.s2oul_android.entity.TheaterInfo
import io.reactivex.Flowable

interface PlaceInfoSource {
    fun loadPlace(): Flowable<ArrayList<TheaterInfo>>
}