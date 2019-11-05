package com.newgram.s2oul_android.data.source.theaterSearch

import com.newgram.s2oul_android.data.remote.RetrofitProvider.api
import com.newgram.s2oul_android.entity.TheaterResult
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object TheaterSearchSourceImpl : TheaterSearchSource {
    override fun searchTheater(word: String): Flowable<Array<TheaterResult>> =
        api.searchTheater(word).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}