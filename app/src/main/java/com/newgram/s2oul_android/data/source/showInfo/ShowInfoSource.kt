package com.newgram.s2oul_android.data.source.showInfo

import com.newgram.s2oul_android.entity.ShowInfo
import io.reactivex.Flowable

interface ShowInfoSource {
    fun loadShowAlphabet(genre: String): Flowable<ArrayList<ShowInfo>>

    fun loadShowDate(genre: String): Flowable<ArrayList<ShowInfo>>
}