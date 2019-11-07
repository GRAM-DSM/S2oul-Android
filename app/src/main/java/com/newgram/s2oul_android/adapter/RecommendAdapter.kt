package com.newgram.s2oul_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R
import com.newgram.s2oul_android.recommend.SliderCard

class RecommendAdapter(val context: Context, val content: Array<Int>): RecyclerView.Adapter<SliderCard>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderCard {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend, parent, false)
        return SliderCard(view)
    }

    override fun onBindViewHolder(holder: SliderCard, position: Int) {
        holder.setContent(content[position % content.size])
    }

    override fun onViewRecycled(holder: SliderCard) {
        holder.clearContent()
    }

    override fun getItemCount(): Int {
        return content.size
    }
}