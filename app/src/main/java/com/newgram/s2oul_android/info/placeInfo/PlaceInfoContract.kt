package com.newgram.s2oul_android.info.placeInfo

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.TheaterInfo

interface PlaceInfoContract {
    interface View: BaseView<Presenter> {
        fun showPlaces(items: ArrayList<TheaterInfo>)
    }

    interface Presenter: BasePresenter {
        fun loadPlace()
    }
}