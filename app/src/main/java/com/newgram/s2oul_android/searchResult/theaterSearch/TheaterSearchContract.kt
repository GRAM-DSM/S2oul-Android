package com.newgram.s2oul_android.searchResult.theaterSearch

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.TheaterResult

interface TheaterSearchContract {
    interface View : BaseView<Presenter> {
        fun showResult(list: ArrayList<TheaterResult>)
        fun goTheaterDetail(theateId: String)
    }

    interface Presenter : BasePresenter {
        fun loadResult(word: String)
    }
}