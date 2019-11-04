package com.newgram.s2oul_android.detail.placeDetail

import android.util.Log
import com.newgram.s2oul_android.data.repository.PlaceDetailRepository
import com.newgram.s2oul_android.entity.Show

class PlaceDetailPresenter(
    private val view: PlaceDetailContract.View
) : PlaceDetailContract.Presenter {

    private val repository =  PlaceDetailRepository

    init {
        view.presenter = this
    }
    override fun start() {

    }
    override fun loadPlace(theaterId: String) {
        var list: ArrayList<Show>
        repository.loadPlace(theaterId).subscribe( {
            list = it.shows
            view.addData(list)
            view.showPlaceDetail(it)
        }, {
            Log.d("loadPlace", "" + it.localizedMessage)
        })
    }
}