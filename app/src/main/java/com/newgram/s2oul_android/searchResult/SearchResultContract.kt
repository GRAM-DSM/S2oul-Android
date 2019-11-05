package com.newgram.s2oul_android.searchResult

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView
import com.newgram.s2oul_android.entity.ShowResult

interface SearchResultContract {
    interface View: BaseView<Presenter> {
        fun showResult(results: Array<ShowResult>)

    }

    interface Presenter: BasePresenter {
        fun loadResult(word: String)
    }
}