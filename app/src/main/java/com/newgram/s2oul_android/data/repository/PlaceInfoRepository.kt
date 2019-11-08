package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.placeInfo.PlaceInfoSource
import com.newgram.s2oul_android.data.source.placeInfo.PlaceInfoSourceImpl
import com.newgram.s2oul_android.entity.TheaterInfo
import io.reactivex.Flowable

object PlaceInfoRepository : PlaceInfoSource{

    private val dataSource = PlaceInfoSourceImpl

    override fun loadPlace(): Flowable<ArrayList<TheaterInfo>> =
        dataSource.loadPlace()
}