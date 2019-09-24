package com.newgram.s2oul_android.recommend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgram.s2oul_android.R

class RecommendAdapter(val context: Context, val content: Array<Int>): RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        return RecommendViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recommend, parent, false))
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return content.size
    }

    inner class RecommendViewHolder(v: View): RecyclerView.ViewHolder(v) {

    }
}