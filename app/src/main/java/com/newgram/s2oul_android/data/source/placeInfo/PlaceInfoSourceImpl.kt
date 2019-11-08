package com.newgram.s2oul_android.data.source.placeInfo

import com.newgram.s2oul_android.data.remote.RetrofitProvider.api
import com.newgram.s2oul_android.entity.TheaterInfo
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PlaceInfoSourceImpl: PlaceInfoSource {
    override fun loadPlace(): Flowable<ArrayList<TheaterInfo>>
        = api.showTheaterAlphabet().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}