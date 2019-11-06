package com.newgram.s2oul_android.data.source.showSearch

import com.newgram.s2oul_android.entity.ShowResult
import io.reactivex.Flowable

interface ShowSearchSource{
    fun searchShow(genre: String,sort: String, word: String): Flowable<Array<ShowResult>>
}