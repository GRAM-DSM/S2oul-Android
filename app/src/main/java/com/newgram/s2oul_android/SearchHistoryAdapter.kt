package com.newgram.s2oul_android

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SearchHistoryAdapter(var context: Context, val items: ArrayList<String>): RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder>() {

    var list = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
        return SearchHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_history, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun filter(text: String) {
        list.clear()
        if (text.length == 0) {
            list = dummy
        } else {
            for (i in 0..dummy.size-1) {
                if (dummy.get(i).toLowerCase().contains(text)) {
                    list.add(dummy.get(i))
                    Log.d("Adapter", dummy.get(i))
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class SearchHistoryViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val searchHistoryTv = v.findViewById<TextView>(R.id.searchHistory_history_tv)

        fun bind(name: String) {
            searchHistoryTv.text = name
        }
    }
}