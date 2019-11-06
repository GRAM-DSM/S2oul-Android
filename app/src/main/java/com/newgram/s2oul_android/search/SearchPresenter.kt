package com.newgram.s2oul_android.search

import android.content.Context
import android.util.Log
import com.newgram.s2oul_android.util.HistoryPref

class SearchPresenter (
    private val view: SearchContract.View, context: Context
): SearchContract.Presenter {

    val editor = HistoryPref(context)
    var list =  ArrayList<String>()

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadRecord() {
        val words = editor.loadData()
        for (i in 0..words.size-1) {
            Log.d("searchpresenter", words.get(i))
        }
        view.showRecord(words)
    }

    override fun saveRecord(word: String) {
        editor.saveData(word)
    }

}