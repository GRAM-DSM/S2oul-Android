package com.newgram.s2oul_android.data.source.showInfo

import com.newgram.s2oul_android.data.remote.RetrofitProvider.api
import com.newgram.s2oul_android.entity.ShowInfo
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ShowInfoSourceImpl : ShowInfoSource {
    override fun loadShowAlphabet(genre: String): Flowable<ArrayList<ShowInfo>> =
        api.showAlphabet(genre).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


    override fun loadShowDate(genre: String): Flowable<ArrayList<ShowInfo>> =
        api.showEndData(genre).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}