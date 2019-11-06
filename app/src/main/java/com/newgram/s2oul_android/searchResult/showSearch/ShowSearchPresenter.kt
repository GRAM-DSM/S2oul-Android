package com.newgram.s2oul_android.searchResult.showSearch

import android.util.Log
import com.newgram.s2oul_android.data.repository.ShowSearchRepository
import com.newgram.s2oul_android.entity.ShowResult

class ShowSearchPresenter (
    private val view: ShowSearchContract.View
): ShowSearchContract.Presenter {

    private val repository = ShowSearchRepository
    private var list = ArrayList<ShowResult>()
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadResult(word: String) {
        repository.searchShow("","",word).subscribe( {
            list = it
            view.showResult(list)
        }, {
            Log.d("showSearch", "loadResult: ${it.localizedMessage}")
        })
    }
}