package com.newgram.s2oul_android.info.showInfo

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.ShowInfo

interface ShowInfoContract {
    interface View: BaseView<Presenter> {
        fun showContents(shows: ArrayList<ShowInfo>)
    }

    interface Presenter: BasePresenter {
        fun loadShowsAlphabet(genre: String)

        fun loadShowsDate(genre: String)
    }
}