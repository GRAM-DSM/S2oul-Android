package com.newgram.s2oul_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.TheaterResult

class TheaterSearchAdapter(val context: Context): RecyclerView.Adapter<TheaterSearchAdapter.TheaterSearchViewHolder>() {

    var items = ArrayList<TheaterResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheaterSearchViewHolder
        = TheaterSearchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_place_result, parent, false))

    override fun getItemCount(): Int
        = items.size

    override fun onBindViewHolder(holder: TheaterSearchViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }
    }

    class TheaterSearchViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: TheaterResult) {

        }
    }
}