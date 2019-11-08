package com.newgram.s2oul_android.info.showInfo

import android.util.Log
import com.newgram.s2oul_android.data.repository.ShowInfoRepository
import com.newgram.s2oul_android.entity.ShowInfo

class ShowInfoPresenter (
    private val view: ShowInfoContract.View
) : ShowInfoContract.Presenter {
    private val repository = ShowInfoRepository
    private var item = ArrayList<ShowInfo>()

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun loadShowsAlphabet(genre: String) {
        repository.loadShowAlphabet(genre).subscribe( {
            item = it
            view.showContents(item)
        }, {
            Log.d("showInfo", "loadShowAlphabet: ${it.localizedMessage}")
        })
    }

    override fun loadShowsDate(genre: String) {
        repository.loadShowDate(genre).subscribe( {
            item = it
            view.showContents(item)
        }, {
            Log.d("showInfo", "loadShowDate: ${it.localizedMessage}")
        })

    }
}