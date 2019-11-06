package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.showSearch.ShowSearchSource
import com.newgram.s2oul_android.data.source.showSearch.ShowSearchSourceImpl
import com.newgram.s2oul_android.entity.ShowResult
import io.reactivex.Flowable

object ShowSearchRepository: ShowSearchSource {
    private val dataSource = ShowSearchSourceImpl

    override fun searchShow(genre: String, sort: String, word: String): Flowable<Array<ShowResult>> =
        dataSource.searchShow(genre, sort, word)

}