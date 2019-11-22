package com.newgram.s2oul_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.ShowInfo
import kotlinx.android.synthetic.main.item_search_show_result.view.*

class ShowSearchAdapter: RecyclerView.Adapter<ShowSearchAdapter.ShowSearchViewHolder>() {

    interface ItemClick {
        fun onClick(v: View, position: Int)
    }

    var itemClick: ItemClick? = null

    var items = ArrayList<ShowInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowSearchViewHolder
        = ShowSearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_show_result, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ShowSearchViewHolder, position: Int) {
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

    class ShowSearchViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ShowInfo) {
            with(view) {
                searchResult_show_name_tv.text = item.showName
                searchResult_show_place_tv.text = item.theaterName
            }
        }
    }

}