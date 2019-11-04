package com.newgram.s2oul_android.detail.showDetail

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView

interface ShowDetailContract {
    interface View: BaseView<Presenter> {
        fun showShowDetail()
        fun showThisTheater()
        fun goPlaceDetail(theaterId: String)
        fun goTicketLink(link: String)
    }


    interface Presenter: BasePresenter {
        fun loadShow(showId: String)
    }
}