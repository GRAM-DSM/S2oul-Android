package com.newgram.s2oul_android.detail.placeDetail

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.Show

interface PlaceDetailContract {

    interface View: BaseView<Presenter> {
        fun showPlaceDetail()
        fun addData(items: ArrayList<Show>)
    }

    interface Presenter: BasePresenter {
        fun loadPlace(theaterId: String)
    }
}