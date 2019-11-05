package com.newgram.s2oul_android.detail.showDetail

import android.util.Log
import com.newgram.s2oul_android.data.repository.ShowDetailRepository

class ShowDetailPresenter(
    private val view: ShowDetailContract.View
): ShowDetailContract.Presenter {

    private val repository = ShowDetailRepository

    init {
        view.presenter = this
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadShow(showId: String) {
        repository.loadShow(showId).subscribe( {
            view.showShowDetail(it)
        }, {
            Log.d("loadShow", "" + it.localizedMessage)
        })
    }
}