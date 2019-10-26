package com.newgram.s2oul_android.detail.placeDetail

import com.newgram.s2oul_android.data.repository.PlaceDetailRepository

class PlaceDetailPresenter(
    private val repository: PlaceDetailRepository,
    private val view: PlaceDetailContract.View
) : PlaceDetailContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {

    }
    override fun loadPlace(theaterId: String) {
        repository.loadPlace(theaterId).subscribe( {

        }, {

        })
    }
}