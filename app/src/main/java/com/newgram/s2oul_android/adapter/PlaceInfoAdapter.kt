package com.newgram.s2oul_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.TheaterInfo
import kotlinx.android.synthetic.main.item_info_place.view.*

class PlaceInfoAdapter: RecyclerView.Adapter<PlaceInfoAdapter.PlaceInfoViewHolder>() {
    interface ItemClick {
        fun onClick(v: View, position: Int)
    }

    var itemClick: ItemClick? = null

    var items = ArrayList<TheaterInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceInfoViewHolder =
        PlaceInfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_info_place, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PlaceInfoViewHolder, position: Int) {
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

    class PlaceInfoViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: TheaterInfo) {
            with(view) {
                info_place_placeName_tv.text = item.theaterName
                info_place_address_tv.text = item.location
                info_place_callNumber_tv.text = item.phoneNumber
                Glide.with(view).load(item.theaterImage).centerCrop().into(info_place_placeImage_iv)
            }
        }
    }
}