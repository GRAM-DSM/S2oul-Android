package com.newgram.s2oul_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.TheaterResult
import kotlinx.android.synthetic.main.item_search_place_result.view.*

class TheaterSearchAdapter(): RecyclerView.Adapter<TheaterSearchAdapter.TheaterSearchViewHolder>() {
    interface ItemClick {
        fun onClick(v: View, position: Int)
    }

    var itemClick: ItemClick? = null

    var items = ArrayList<TheaterResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheaterSearchViewHolder
        = TheaterSearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_place_result, parent, false))

    override fun getItemCount(): Int
        = items.size

    override fun onBindViewHolder(holder: TheaterSearchViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }

        if(itemClick != null) {
            holder?.itemView?.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }
    }

    class TheaterSearchViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: TheaterResult) {
            with(view) {
                searchResult_place_name_tv.text = item.theaterName
                searchResult_place_place_tv.text = item.location
                searchResult_place_number_tv.text = item.phoneNumber
            }
        }
    }
}