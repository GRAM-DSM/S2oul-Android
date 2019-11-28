package com.newgram.s2oul_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.entity.TheaterInfo

class MapAdapter: RecyclerView.Adapter<MapAdapter.MapViewHolder>() {

    var items = arrayListOf<TheaterInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder =
        MapViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_info_place, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MapViewHolder(v: View): RecyclerView.ViewHolder(v) {

    }
}