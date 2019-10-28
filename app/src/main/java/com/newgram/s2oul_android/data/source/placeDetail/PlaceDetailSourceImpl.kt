package com.newgram.s2oul_android.data.source.placeDetail

import com.newgram.s2oul_android.data.remote.S2oulAPI
import com.newgram.s2oul_android.entity.TheaterDetail
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlaceDetailSourceImpl(private val api: S2oulAPI):
    PlaceDetailSource {
    override fun loadPlace(theaterId: String): Flowable<TheaterDetail> =
        api.getTheater(theaterId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}