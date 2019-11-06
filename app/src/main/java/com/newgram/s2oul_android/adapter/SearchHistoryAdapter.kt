package com.newgram.s2oul_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R

class SearchHistoryAdapter(var context: Context): RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder>() {

    var list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
        return SearchHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_history, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class SearchHistoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val searchHistoryTv = view.findViewById<TextView>(R.id.searchHistory_history_tv)

        fun bind(name: String) {
            searchHistoryTv.text = name
        }
    }
}