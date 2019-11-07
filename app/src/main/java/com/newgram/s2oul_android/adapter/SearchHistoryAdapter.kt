package com.newgram.s2oul_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R

class SearchHistoryAdapter(var context: Context): RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder>() {
    interface ItemClick {
        fun onClick(v: View, position: Int)
    }

    var itemClick: ItemClick? = null

    var list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
        return SearchHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_history, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        holder.run {
            list[position].let {
                bind(it)
            }
        }
        if(itemClick != null) {
            holder?.itemView?.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }
    }

    inner class SearchHistoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val searchHistoryTv = view.findViewById<TextView>(R.id.searchHistory_history_tv)
        fun bind(name: String) {
            searchHistoryTv.text = name
        }
    }
}