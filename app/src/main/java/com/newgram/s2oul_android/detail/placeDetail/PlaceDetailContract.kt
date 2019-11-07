package com.newgram.s2oul_android.detail.placeDetail

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.Show
import com.newgram.s2oul_android.entity.TheaterDetail

interface PlaceDetailContract {

    interface View: BaseView<Presenter> {
        fun showPlaceDetail(theater: TheaterDetail)
        fun addData(items: ArrayList<Show>)
        fun goShowDetail(showId: String)
    }

    interface Presenter: BasePresenter {
        fun loadPlace(theaterId: String)
    }
}