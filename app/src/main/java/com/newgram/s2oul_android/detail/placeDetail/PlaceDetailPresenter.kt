package com.newgram.s2oul_android.detail.placeDetail

import com.newgram.s2oul_android.data.repository.PlaceDetailRepository
import com.newgram.s2oul_android.entity.Show

class PlaceDetailPresenter(
    private val view: PlaceDetailContract.View
) : PlaceDetailContract.Presenter {

    private val repository =  PlaceDetailRepository

    init {
        view.presenter = this
    }

    private var image: String = ""
    private var name: String = ""
    private var number: String = ""
    private var address: String = ""
    private var seat: String = ""

    override fun start() {

    }
    override fun loadPlace(theaterId: String) {
        var list: ArrayList<Show>
        repository.loadPlace(theaterId).subscribe( {
            list = it.shows
            image = it.image
            name = it.name
            number = it.phoneNumber
            address = it.location
            seat = it.seatNumber
            view.addData(list)
            view.showPlaceDetail()
        }, {

        })
    }
}