package com.newgram.s2oul_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.ShowInfo
import kotlinx.android.synthetic.main.item_info_show.view.*

class ShowInfoAdapter: RecyclerView.Adapter<ShowInfoAdapter.ShowInfoViewHolder>() {

    var items = ArrayList<ShowInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowInfoViewHolder =
        ShowInfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_info_show, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ShowInfoViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }
    }

    class ShowInfoViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ShowInfo) {
            with(view) {
                info_show_showName_tv.text = item.showName
                info_show_age_tv.text = item.showAge
                info_show_date_tv.text = item.period
                Glide.with(context).load(item.showImage).into(info_show_showImage_iv)
            }
        }
    }
}