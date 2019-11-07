package com.newgram.s2oul_android.searchResult.theaterSearch

import android.util.Log
import com.newgram.s2oul_android.data.repository.TheaterSearchRepository
import com.newgram.s2oul_android.entity.TheaterResult

class TheaterSearchPresenter (
    private val view: TheaterSearchContract.View
) : TheaterSearchContract.Presenter {

    private val repository = TheaterSearchRepository
    private var items = ArrayList<TheaterResult>()
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadResult(word: String) {
        repository.searchTheater(word).subscribe( {
            items = it
            view.showResult(items)
        }, {
            Log.d("theaterSearch", "loadResult: ${it.localizedMessage}")
        })
    }
}