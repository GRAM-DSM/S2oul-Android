package com.newgram.s2oul_android.detail.placeDetail

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView

interface PlaceDetailContract {

    interface View: BaseView<Presenter> {
        fun showPlaceDetail()
    }

    interface Presenter: BasePresenter {
        fun loadPlace(theaterId: String)
    }
}