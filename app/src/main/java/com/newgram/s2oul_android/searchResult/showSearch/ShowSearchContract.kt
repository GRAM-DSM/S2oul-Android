package com.newgram.s2oul_android.searchResult.showSearch

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.ShowResult

interface ShowSearchContract {
    interface View: BaseView<Presenter> {
        fun showResult(list: ArrayList<ShowResult>)
        fun goDetail(id: String)
    }

    interface Presenter: BasePresenter {
        fun loadResult(word: String)
    }
}