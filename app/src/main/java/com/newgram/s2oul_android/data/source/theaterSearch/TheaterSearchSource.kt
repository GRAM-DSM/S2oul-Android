package com.newgram.s2oul_android.data.source.theaterSearch

import com.newgram.s2oul_android.entity.TheaterResult
import io.reactivex.Flowable

interface TheaterSearchSource{
    fun searchTheater(word: String): Flowable<Array<TheaterResult>>
}