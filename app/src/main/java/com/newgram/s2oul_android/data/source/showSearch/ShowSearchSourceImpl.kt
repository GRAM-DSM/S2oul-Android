package com.newgram.s2oul_android.data.source.showSearch

import com.newgram.s2oul_android.data.remote.RetrofitProvider.api
import com.newgram.s2oul_android.entity.ShowResult
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ShowSearchSourceImpl : ShowSearchSource {
    override fun searchShow(genre: String, sort: String, word: String): Flowable<Array<ShowResult>> =
        api.searchShow(genre, sort, word).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}