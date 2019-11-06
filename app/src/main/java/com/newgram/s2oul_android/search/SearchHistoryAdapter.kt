package com.newgram.s2oul_android.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R

class SearchHistoryAdapter(var context: Context): RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder>() {

    var list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder {
        return SearchHistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_history, parent, false))
    }

    override fun getItemCount() = 0

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        holder.bind(list[position])
        notifyDataSetChanged()
    }

//    fun filter(text: String) {
//        list.clear()
//        if (text.length == 0) {
//            list = dummy
//        } else {
//            for (i in 0..dummy.size-1) {
//                if (dummy.get(i).toLowerCase().contains(text)) {
//                    list.add(dummy.get(i))
//                    Log.d("Adapter", dummy.get(i))
//                }
//            }
//        }
//        notifyDataSetChanged()
//    }

    inner class SearchHistoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val searchHistoryTv = view.findViewById<TextView>(R.id.searchHistory_history_tv)

        fun bind(name: String) {
            searchHistoryTv.text = name
        }
    }
}