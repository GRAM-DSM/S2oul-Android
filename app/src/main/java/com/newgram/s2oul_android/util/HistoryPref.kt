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

            Log.d("history","$value")
            dataList.add("$value")
        }

        Log.d("history", "load")
        return dataList

//        return pref.getString("HISTORY", null)
//        return pref.all
//        var array =  ArrayList<String>()
//        if (word != null) {
//            try {
//                var a = JSONArray(word)
//                for (i in 0..a.length()) {
//                    val url = a.optString(i)
//                    array.add(url)
//                }
//            } catch (e: JSONException) {
//                e.printStackTrace()
//            }
//        }
//        return array
    }

    fun deleteData(word: String) {

    }

}