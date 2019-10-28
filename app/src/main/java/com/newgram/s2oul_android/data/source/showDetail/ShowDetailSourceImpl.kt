package com.newgram.s2oul_android.data.source.showDetail

import com.newgram.s2oul_android.data.remote.S2oulAPI
import com.newgram.s2oul_android.entity.ShowDetail
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ShowDetailSourceImpl (
    private val api: S2oulAPI
): ShowDetailSource {
    override fun loadShow(showId: String): Flowable<ShowDetail> =
        api.getShow(showId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}