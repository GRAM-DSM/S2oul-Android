package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.theaterSearch.TheaterSearchSource
import com.newgram.s2oul_android.data.source.theaterSearch.TheaterSearchSourceImpl
import com.newgram.s2oul_android.entity.TheaterResult
import io.reactivex.Flowable

object TheaterSearchRepository: TheaterSearchSource {
    private val dataSource = TheaterSearchSourceImpl

    override fun searchTheater(word: String): Flowable<ArrayList<TheaterResult>> =
        dataSource.searchTheater(word)
}