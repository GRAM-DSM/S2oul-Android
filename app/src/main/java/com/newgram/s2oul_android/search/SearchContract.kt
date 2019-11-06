package com.newgram.s2oul_android.search

import com.newgram.s2oul_android.BasePresenter
import com.newgram.s2oul_android.BaseView

interface SearchContract {
    interface View: BaseView<Presenter> {
        fun showRecord(words: ArrayList<String>)
        fun goSearchResult()
    }

    interface Presenter: BasePresenter {
        fun saveRecord(word: String)
        fun loadRecord()
    }
}