package com.newgram.s2oul_android.util

import android.content.Context
import android.util.Log

class HistoryPref (context: Context) {

    private val pref = context.getSharedPreferences("SearchHistory", Context.MODE_PRIVATE)

    fun saveData(word: String) {
        Log.d("history", "save")
        pref.edit().putString(word, word).apply()
    }

    fun loadData(): ArrayList<String> {
        var dataList = ArrayList<String>()
        var totalValue: Map<String, *> = pref.all

        for ((key, value) in totalValue) {
            dataList.add("$value")
        }

        Log.d("history", "load")
        return dataList

    }

    fun deleteData() {
        pref.edit().clear()
        pref.edit().commit()
    }

}