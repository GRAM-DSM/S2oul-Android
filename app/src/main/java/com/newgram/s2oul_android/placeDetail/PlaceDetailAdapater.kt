package com.newgram.s2oul_android.placeDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R

class PlaceDetailAdapater(val context: Context): RecyclerView.Adapter<PlaceDetailAdapater.PlaceDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceDetailViewHolder {
        return PlaceDetailViewHolder(LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PlaceDetailViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class PlaceDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind() {

        }
    }

}