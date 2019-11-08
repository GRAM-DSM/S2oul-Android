package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.showInfo.ShowInfoSource
import com.newgram.s2oul_android.data.source.showInfo.ShowInfoSourceImpl
import com.newgram.s2oul_android.entity.ShowInfo
import io.reactivex.Flowable

object ShowInfoRepository: ShowInfoSource {

    private val dataSource = ShowInfoSourceImpl

    override fun loadShowAlphabet(genre: String): Flowable<ArrayList<ShowInfo>> =
        dataSource.loadShowAlphabet(genre)


    override fun loadShowDate(genre: String): Flowable<ArrayList<ShowInfo>> =
        dataSource.loadShowDate(genre)
}