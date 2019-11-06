package com.newgram.s2oul_android.searchResult.showSearch

import com.newgram.s2oul_android.data.repository.ShowSearchRepository

class ShowSearchPresenter (
    private val view: ShowSearchContract.View
): ShowSearchContract.Presenter {

    private val repository = ShowSearchRepository
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadResult(word: String) {
        repository.searchShow("","",word).subscribe( {

        }, {

        })
    }
}