package com.newgram.s2oul_android.detail.showDetail

import com.newgram.s2oul_android.data.repository.ShowDetailRepository

class ShowDetailPresenter(
    private val repository: ShowDetailRepository,
    private val view: ShowDetailContract.View
): ShowDetailContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadShow(showId: String) {
        repository.loadShow(showId).subscribe( {
            it.showName
            it.showImage
            it.period
            it.cost
            it.location
            it.runningTime
            it.summaryImage
            it.theaterId
            it.theaterImage
            it.theaterName
            it.link
            it.phoneNumber
            it.theaterId
            view.showShowDetail()
            view.showThisTheater()
        }, {

        })
    }
}