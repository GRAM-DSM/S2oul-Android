package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.placeDetail.PlaceDetailSource
import com.newgram.s2oul_android.entity.TheaterDetail
import io.reactivex.Flowable

class PlaceDetailRepository(private val dataSource: PlaceDetailSource):
    PlaceDetailSource {
    override fun loadPlace(theaterId: String): Flowable<TheaterDetail> =
        dataSource.loadPlace(theaterId)
}