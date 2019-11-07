package com.newgram.s2oul_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.ShowResult

class ShowSearchAdapter(val context: Context): RecyclerView.Adapter<ShowSearchAdapter.ShowSearchViewHolder>() {

    var items = ArrayList<ShowResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowSearchViewHolder
        = ShowSearchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_show_result, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ShowSearchViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }
    }

    class ShowSearchViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ShowResult) {

        }
    }

}