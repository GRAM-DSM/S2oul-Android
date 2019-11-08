package com.newgram.s2oul_android.info.placeInfo

import android.util.Log
import com.newgram.s2oul_android.data.repository.PlaceInfoRepository

class PlaceInfoPresenter (
    private val view: PlaceInfoContract.View
): PlaceInfoContract.Presenter {
    private val repository = PlaceInfoRepository

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun loadPlace() {
        repository.loadPlace().subscribe( {
            view.showPlaces(it)
        }, {
            Log.d("placeInfo", "loadPlace: ${it.localizedMessage}")
        })
    }
}