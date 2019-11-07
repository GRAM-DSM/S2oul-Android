package com.newgram.s2oul_android.data.source.showDetail

import com.newgram.s2oul_android.entity.ShowDetail
import io.reactivex.Flowable

interface ShowDetailSource {
    fun loadShow(showId: String): Flowable<ShowDetail>
}