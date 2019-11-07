package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.placeDetail.PlaceDetailSource
import com.newgram.s2oul_android.data.source.placeDetail.PlaceDetailSourceImpl
import com.newgram.s2oul_android.entity.TheaterDetail
import io.reactivex.Flowable

object PlaceDetailRepository :
    PlaceDetailSource {

    private val dataSource = PlaceDetailSourceImpl

    override fun loadPlace(theaterId: String): Flowable<TheaterDetail> =
        dataSource.loadPlace(theaterId)
}