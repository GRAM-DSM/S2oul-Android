package com.newgram.s2oul_android.detail.showDetail

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.ShowDetail

interface ShowDetailContract {
    interface View: BaseView<Presenter> {
        fun showShowDetail(show: ShowDetail)
        fun goPlaceDetail(theaterId: String)
        fun goTicketLink(link: String)
    }

    interface Presenter: BasePresenter {
        fun loadShow(showId: String)
    }
}